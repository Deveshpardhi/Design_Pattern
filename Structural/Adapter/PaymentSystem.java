package Adapter;

// Step 1: Define the PaymentGateway Interface (Target Interface)
interface PaymentGateway {
    void makePayment(String amount);
}

// Step 2: Implement the PayPal class (Adaptee)
class PayPal {
    public void makePaymentWithPayPal(String amount) {
        System.out.println("Payment of " + amount + " made using PayPal.");
    }
}

// Step 3: Implement the Stripe class (Adaptee)
class Stripe {
    public void processPayment(String amount) {
        System.out.println("Payment of " + amount + " processed using Stripe.");
    }
}

// Step 4: Implement the Square class (Adaptee)
class Square {
    public void payUsingSquare(String amount) {
        System.out.println("Payment of " + amount + " made using Square.");
    }
}

// Step 5: Implement the Adapter classes for each Payment Gateway

// PayPalAdapter class adapts PayPal to the PaymentGateway interface
class PayPalAdapter implements PaymentGateway {
    private PayPal payPal;

    public PayPalAdapter() {
        this.payPal = new PayPal();
    }

    @Override
    public void makePayment(String amount) {
        payPal.makePaymentWithPayPal(amount);
    }
}

// StripeAdapter class adapts Stripe to the PaymentGateway interface
class StripeAdapter implements PaymentGateway {
    private Stripe stripe;

    public StripeAdapter() {
        this.stripe = new Stripe();
    }

    @Override
    public void makePayment(String amount) {
        stripe.processPayment(amount);
    }
}

// SquareAdapter class adapts Square to the PaymentGateway interface
class SquareAdapter implements PaymentGateway {
    private Square square;

    public SquareAdapter() {
        this.square = new Square();
    }

    @Override
    public void makePayment(String amount) {
        square.payUsingSquare(amount);
    }
}

// Step 6: Create the PaymentService class that uses PaymentGateway interface
class PaymentService {
    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void processPayment(String amount) {
        paymentGateway.makePayment(amount);
    }
}

// Step 7: Client class demonstrating the use of different Payment Gateways
public class PaymentSystem {
    public static void main(String[] args) {
        // Using PayPal through its Adapter
        PaymentGateway payPalAdapter = new PayPalAdapter();
        PaymentService payPalService = new PaymentService(payPalAdapter);
        payPalService.processPayment("100 USD");

        // Using Stripe through its Adapter
        PaymentGateway stripeAdapter = new StripeAdapter();
        PaymentService stripeService = new PaymentService(stripeAdapter);
        stripeService.processPayment("200 USD");

        // Using Square through its Adapter
        PaymentGateway squareAdapter = new SquareAdapter();
        PaymentService squareService = new PaymentService(squareAdapter);
        squareService.processPayment("150 USD");
    }
}
