package AdapterPatternExample;

public class RazorpayGateway
{
    public void makeTransaction(double amount)
    {
        System.out.println("Payment of ₹" + amount + " processed via Razorpay");
    }
}
