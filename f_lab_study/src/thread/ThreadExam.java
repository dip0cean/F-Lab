package thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ThreadExam implements Serializable {
    public static void main(String[] args) throws Exception {
        BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));
        String         input = br.readLine();

        Bank bank = new Bank();
        bank.open(Arrays.stream(input.split(",")).map(TransactionRequest::new).collect(Collectors.toList()));

        if (bank.peakRequests <= 1) {
            System.err.println("WARN: Only one thread is used for processing. It can be a reason of low performance.");
        }

        System.out.println(bank.getCurrentAccountReport());
    }

    static class TransactionRequest {
        String  accountId;
        Integer amount;

        TransactionRequest(String order) {
            String[] tokens = order.split(":", 2);
            this.accountId = tokens[0].trim();
            this.amount = Integer.valueOf(tokens[1].trim());
        }
    }

    static class Account {
        AtomicInteger balance = new AtomicInteger();

        Integer transact(Integer amount) {
            return balance.addAndGet(amount);
        }
    }

    public static class Bank {
        Map<String, Account> accounts = new ConcurrentHashMap<>();

        private AtomicInteger currentRequestCount = new AtomicInteger();
        int peakRequests = 0;

        Integer request(TransactionRequest request) {
            int newPeak = currentRequestCount.incrementAndGet();

            if (peakRequests < newPeak) {
                peakRequests = newPeak;
            }

            Account account = accounts.getOrDefault(request.accountId, new Account());
            accounts.putIfAbsent(request.accountId, account);
            Integer remain = accounts.get(request.accountId).transact(request.amount);

            currentRequestCount.decrementAndGet();
            return remain;
        }

        void open(List<TransactionRequest> requests) {
            requests.parallelStream().forEach(this::request);
        }

        String getCurrentAccountReport() {
            return accounts.entrySet().stream()
                    .map(e -> String.format("%s:%d", e.getKey(), e.getValue().balance.intValue()))
                    .collect(Collectors.joining("\n"));
        }
    }
}
