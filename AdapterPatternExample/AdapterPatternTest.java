package AdapterPatternExample;

public class AdapterPatternTest
{
    public static void main(String[] args) {

        PaymentProcessor paypal = new PayPalAdapter();
        paypal.processPayment(100.50);

        PaymentProcessor razorpay = new RazorpayAdapter();
        razorpay.processPayment(2500);

        PaymentProcessor stripe = new StripeAdapter();
        stripe.processPayment(75.99);
    }
}
