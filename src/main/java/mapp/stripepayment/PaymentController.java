
package mapp.stripepayment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PaymentController {

    @Value("${stripe.keys.public}")
    private String API_PUBLIC_KEY;

    private StripeService stripeService;

    public PaymentController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @GetMapping("/charge")
    public String chargePage(Model model) {
        model.addAttribute("stripePublicKey", API_PUBLIC_KEY);
        return "charge";
    }

    @PostMapping("/create-charge")
    public @ResponseBody
    Response createCharge(String email, String token, String total) {
        //validate data
        if (token == null) {
            return new Response(false, "Stripe payment token is missing. Please, try again later.");
        }
        System.out.println(total);
        //create charge
        String chargeId = stripeService.createCharge(email, token, Integer.parseInt(total)); //$9.99 USD
        if (chargeId == null) {
            return new Response(false, "An error occurred while trying to create a charge.");
        }

        // You may want to store charge id along with order information
        return new Response(true, "Success! Your charge id is " + chargeId);
    }
}
