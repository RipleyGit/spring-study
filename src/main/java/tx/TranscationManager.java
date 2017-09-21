package tx;

import org.springframework.stereotype.Component;

@Component("tx")
public class TranscationManager {
    public void begin(){
        System.out.println("Transaction is begin!");
    }

    public void rollback() {
        System.out.println("Transaction is rollback!");
    }
    public void commit(){
        System.out.println("Transaction is commit!");
    }
}
