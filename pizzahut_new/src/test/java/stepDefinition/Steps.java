package stepDefinition;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.pizzahutPages.DealsPage;
import com.pizzahutPages.DrinksPage;
import com.pizzahutPages.HomePage;
import com.pizzahutPages.PizzaPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Steps {

	HomePage homepage = new HomePage();
	DealsPage dealspage = new DealsPage();
	PizzaPage pizzapage = new PizzaPage();
	DrinksPage drinkspage = new DrinksPage();

	@Given("User launch Pizzahut application with {string}")
	public void user_launch_pizzahut_application_with(String string) {

		homepage.openPizzaHutWebsite(string);

	}

//    @When("User wait for auto location black pop up screen")
//    public void user_wait_for_auto_location_black_pop_up_screen() {
//        // Write code here that turns the phrase above into concrete actions
//        System.out.println("hello");
//    }
//    @Then("User close the pop up screen")
//    public void user_close_the_pop_up_screen() {
//        // Write code here that turns the phrase above into concrete actions
//        System.out.println("hello");
//    }

	@When("User see pop up for delivery asking for enter location")
	public void user_see_pop_up_for_delivery_asking_for_enter_location() {
		homepage.userFindsLocation();
	}

	@Then("User type address as {string}")
	public void user_type_address_as(String string) {

		homepage.enterLocation(string);
	}

	@Then("User select first auto populate drop down option")
	public void user_select_first_auto_populate_drop_down_option() {

		homepage.selectAutoPopulateOption();

	}

	@When("User navigate to deals page")
	public void user_navigate_to_deals_page() {
		dealspage.inDealsPage();
		System.out.println("- - - - - - - - - - - - - - - - - - ");
	}

	@Then("User validate vegetarian radio button flag is off")
	public void user_validate_vegetarian_radio_button_flag_is_off() {
		// Write code here that turns the phrase above into concrete actions

		assertTrue(dealspage.isVegetarianRadioButtonOff());
		System.out.println("- - - - - - - - - - - - - - - - - - ");

	}

	@Then("User clicks on Pizzas menu bar option")
	public void user_clicks_on_pizzas_menu_bar_option() {
		// Write code here that turns the phrase above into concrete actions

		dealspage.clickPizzasMenuBar();
		System.out.println("- - - - - - - - - - - - - - - - - - ");

	}

	@When("User select add button of any pizza from Recommended")
	public void user_select_add_button_of_any_pizza_from_recommended() {
		// Write code here that turns the phrase above into concrete actions

		pizzapage.selectAddButtonOfRecommendedPizza();
		System.out.println("- - - - - - - - - - - - - - - - - - ");
	}

	@Then("User see that the pizza is getting added under Your Basket")
	public void user_see_that_the_pizza_is_getting_added_under_your_basket() {
		// Write code here that turns the phrase above into concrete actions

		assertTrue(pizzapage.isPizzaAddedToBasket());
		System.out.println("- - - - - - - - - - - - - - - - - - ");

	}

	@Then("User validate pizza price plus Tax is checkout price")
	public void user_validate_pizza_price_plus_tax_is_checkout_price() {

		assertTrue(pizzapage.validating_pizzaPrice_checkoutPrice());
		System.out.println("- - - - - - - - - - - - - - - - - - ");
		
	}

	@Then("User validate checkout button contains Item count")
	public void user_validate_checkout_button_contains_item_count() {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(pizzapage.checkoutContainsItems());
		System.out.println("- - - - - - - - - - - - - - - - - - ");
		

	}

	@Then("User validate checkout button contains total price count")
	public void user_validate_checkout_button_contains_total_price_count() {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(pizzapage.checkoutContainsPrice());
		System.out.println("- - - - - - - - - - - - - - - - - - ");
		
	}

	@Then("User clicks on Drinks option")
	public void user_clicks_on_drinks_option() {
		// Write code here that turns the phrase above into concrete actions
		pizzapage.clickDrinks();
		System.out.println("- - - - - - - - - - - - - - - - - - ");
		
	}

	@Then("User select Pepsi option to add into the Basket")
	public void user_select_pepsi_option_to_add_into_the_basket() {

		drinkspage.addPepsi();
		System.out.println("- - - - - - - - - - - - - - - - - - ");

	}

	@Then("User see {int} items are showing under checkout button")
	public void user_see_items_are_showing_under_checkout_button(Integer int1) {

		assertTrue(drinkspage.twoItemsInCheckoutButton());
		System.out.println("- - - - - - - - - - - - - - - - - - ");

	}

	@Then("User see total price is now more than before")
	public void user_see_total_price_is_now_more_than_before() {
		// Write code here that turns the phrase above into concrete actions

		assertTrue(drinkspage.totalPriceIsMoreThanBefore());
		System.out.println("- - - - - - - - - - - - - - - - - - ");
	}

	@Then("User remove the Pizza item from Basket")
	public void user_remove_the_pizza_item_from_basket() {

		drinkspage.removePizza();
		System.out.println("- - - - - - - - - - - - - - - - - - ");

	}

	@Then("see Price tag got removed from the checkout button")
	public void see_price_tag_got_removed_from_the_checkout_button() {

		assertFalse(drinkspage.priceTagRemovedFromCheckout());
		System.out.println("- - - - - - - - - - - - - - - - - - ");

	}

	@Then("User see {int} item showing in checkout button")
	public void user_see_item_showing_in_checkout_button(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assertTrue(drinkspage.itemsInCheckoutISOne());
		System.out.println("- - - - - - - - - - - - - - - - - - ");
	}

	@Then("User Clicks on Checkout button")
	public void user_clicks_on_checkout_button() {
		// Write code here that turns the phrase above into concrete actions
		drinkspage.clickCheckout();
		System.out.println("- - - - - - - - - - - - - - - - - - ");
	}

	@Then("User see minimum order required pop up is getting displayed")
	public void user_see_minimum_order_required_pop_up_is_getting_displayed() {
		// Write code here that turns the phrase above into concrete actions

		assertTrue(drinkspage.minOrderPopupDisplays());
		System.out.println("- - - - - - - - - - - - - - - - - - ");
	}

}
