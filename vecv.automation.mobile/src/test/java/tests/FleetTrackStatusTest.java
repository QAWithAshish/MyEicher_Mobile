package tests;

import DataFactory.TrackingView;
import com.aventstack.extentreports.Status;
import logger.LogReporter;
import org.openqa.selenium.Platform;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pageObjects.FleetTrackingScreen;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.SelectCustomerPage;
import reporter.ExtentTestManager;


import static reporter.ExtentTestManager.startTest;

public class FleetTrackStatusTest extends GetPage {



    @Test(priority = 1)
    public void TrackLandingPageTabs()   {
        startTest("Track Landing Page Tab Status", "Track landing page should have 4 tabs i.e. Moving, Idling, Stopped & Not Reachable.");
        LogReporter.INFO("Starting test");
        LoginPage page =new LoginPage(factory.getDriver());
        page.skipToLogin().performLogin().gettingStarted();
        SelectCustomerPage customerPage =new SelectCustomerPage(factory.getDriver());
        customerPage.submitCustomerDetails();
        getLandingPage().acceptLayoutHint()
                .navigateToFleetTracking();
        getFleetTrackingScreen()
                .validateStatusAndValues();



    }

    @Test(priority = 2)
    public void ValidateCategorySwitchVehicleState()   {
        startTest("Track Landing Page Category Switch Filters", "Click on specific category should update the map and list view showing vehicles in that category. \n" +
                "Example: Click on moving tab should update the landing page and show moving vehicles on Map/List." +
                "Listview should have a list of vehicles depending on the category selected.");


        getFleetTrackingScreen()
                .validateMovingCategory()
                .validateIdleCategory()
                .validateStoppedCategory()
                .validateNotReachable();
    }



    @Test(priority = 3)
    public void SwitchToDefaultView()   {
        startTest("Default View Appear when all categories clicked", "If user selects 3 category and tries to select 4th category, it sets to default. ");
        getFleetTrackingScreen()
                .selectCategories();
    }



    @Test(priority = 4)
    public void SwitchMaptoListView()   {
        startTest("Change View to List", " Click on List button on map page will switch the view to list view. ");
        getLandingPage().navigateToFleetTracking();
        getFleetTrackingScreen()
                .swichTrackingView(TrackingView.List);
        getFleetTrackingScreen()
                .navigateToHome();
    }

    @Test(priority = 5)
    public void SwitchListViewtoMapView()   {
        startTest("Change View to Map", "Click on Map button on list page will switch the view to map view. ");
        getLandingPage().navigateToFleetTracking();
        getFleetTrackingScreen()
                .swichTrackingView(TrackingView.List)
                .swichTrackingView(TrackingView.Map);
        getFleetTrackingScreen().navigateToHome();
    }


    @Test(priority = 6)
    public void ValidateVehicleDetailsInListView()   {
        startTest("Verify vehicle details",
                "Vehicle health should be visible for all vehicles in the list view " +
                        "Last updated time and location should be visible for all vehicles." +
                        "Fuel level (Lts) should be visible for all vehicles." +
                        "Odometer should be visible for all vehicles.");

        getFleetTrackingScreen().validateVehicleReadings();
        getFleetTrackingScreen().navigateToHome();

    }

    @Test(priority = 7)
    public void ValidateOneVehicleDetailsInListView()   {
        startTest("Verify one vehicle details", "Click on individual vehicle on list view will open detailed vehicle map.");
        getFleetTrackingScreen()
                .validateOneVehicleDetails();
        getFleetTrackingScreen()
                .navigateToHome();

    }
    @Test(priority = 8)
    public void ValidateOneVehicleDetailsCategoriesInListView()   {
        startTest("Verify one vehicle details Categories", "Detailed view should have 3 categories - Current Status, Playback & Trace, and Quick Links.");
        getFleetTrackingScreen().validateOneVehicleDetails().
                validateOneVehicleDetailsCategories();
    }

    @Test(priority = 9)
    public void validateDetailedMapForIndividualVehicles()   {
        startTest("Validate Detailed Map for Individual Vehicle", "Click on individual vehicle on map view will open detailed vehicle map.");

        if( driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase(Platform.ANDROID.toString())) {

            getFleetTrackingScreen().openDetailedVehicleMap();

        }else{
            ExtentTestManager.getTest().log(Status.SKIP, "Test is not supported by iOS");
            throw new SkipException("Test is not available in iOS");
        }
    }

    @Test(priority = 10)
    public void validateVehicleSheetforMapCluster()   {
        startTest("Validate Grid Table  for cluster Vehicle", "Click on vehicle cluster on map will zoom the map view and scatter the vehicle and location. ");
        if( driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase(Platform.ANDROID.toString())) {


            getFleetTrackingScreen().openClusterVehicleMap();
    }else{
            ExtentTestManager.getTest().log(Status.SKIP, "Test is not supported by iOS");
        throw new SkipException("Test is not available in iOS");
    }
    }

    @Test(priority = 11)
    public void validateSearchFilter()   {
        startTest("filter view by Vehicle and location", "Search button should let user to filter the view based on vehicles or location.");
        if( driver.getCapabilities().getPlatformName().toString().equalsIgnoreCase(Platform.ANDROID.toString())) {


            getFleetTrackingScreen().filterViewByVehicle();
            getFleetTrackingScreen().filterViewByLocation();
        }else{
            ExtentTestManager.getTest().log(Status.SKIP, "Test is not supported by iOS");
            throw new SkipException("Test is not available in iOS");
        }
    }

    @Test(priority = 12)
    public void validateSearchFilterWithCategorySwitch() throws InterruptedException {
        startTest("filter view by Vehicle and category switch", "If vehicles/ category are filtered on map view should be applicable on List view as well and vice versa. ");
        getFleetTrackingScreen().categorySwitchViewByVehicle();
    }


    @Test(priority = 13)
    public void ValidateOneVehicleRealTimeDetails()   {
               startTest("Verify vehicle real time details", "On current status, real time vehicle movement track should be visible on map. ");

        getFleetTrackingScreen().validateOneVehicleDetails().
                             VehicleRealTimeDetails()
                        .navigateToHome();
    }

   @Test(priority = 14)
    public void ValidateAllRealTimeDetailsOfVehicle() throws InterruptedException {
        startTest("Verify all real time details for vehicle", "Real time speed as per last updated time should be visible. " +
                "Real time odometer as per last updated time should be visible. " +
                "Real time sweet spot as per last updated time should be visible only for applicable vehicles. " +
                "Real time DEF level as per last updated time should be visible only for applicable vehicles. " +
                "User must be able to view past 24 hours performance from the time they are viewing the tab. ");

                getFleetTrackingScreen().validateOneVehicleDetails().
                allRealTimeVehicleDetails().navigateToHome();
 }


    @Test(priority = 15)
    public void ValidateNoPioletAssigned() throws InterruptedException {
        startTest("Validate No Pilot Assigned", "If no pilot is assigned then text No Pilot Assigned should be visible. ");

        getFleetTrackingScreen().validateOneVehicleDetails().noPilotAssigned();

    }

    @Test(priority = 16)
    public void ValidateShareLiveLocation() throws InterruptedException {
        startTest("Verify Share live location", "User must be able to share Live location for specific vehicle ");

        getFleetTrackingScreen().validateOneVehicleDetails().
                shareVehicleLiveLocation().navigateToHome();
    }

    @Test(priority = 17)
    public void ValidateCurrentLiveLocation() throws InterruptedException {
        startTest("Verify Share current location", "User can able to share current location of the vehicle");

        getFleetTrackingScreen().validateOneVehicleDetails().
                shareVehicleCurrentLocation()
                .navigateToHome();
    }


    @Test(priority = 18)
    public void ValidateQuickLinksVehicleDetails() {
        startTest("Verify quick links Vehicle details", "Click on vehicle details CTA, user  will navigate user to vehicle one view on My Organization -> detailed view ");

        getFleetTrackingScreen().validateOneVehicleDetails().
                quickLinksTabVehicleDetails();
        getFleetTrackingScreen().navigateToHome();

    }



    @Test(priority = 19)
    public void ValidateQuickLinksFuelServices() {
        startTest("Verify quick links fuel services", "Click on Fuel Services CTA, user will navigate user to vehicle one view on Fuel Management -> Fuel Refill and Drain with vehicle selected.");

        getFleetTrackingScreen().validateOneVehicleDetails().
                quickLinksTabFuelServices()
                .navigateToHome();

    }



    @Test(priority = 20)
    public void ValidateQuickLinksFuelGraph() {
        startTest("Verify quick links fuel graph", "Click on Fuel Services CTA, user will navigate user to vehicle one view on Fuel Management -> Fuel Graph with vehicle selected");

        getFleetTrackingScreen().validateOneVehicleDetails().
                quickLinksTabFuelGraph()
                .navigateToHome();

    }




    @Test(priority = 21)
    public void ValidateQuickLinksFleetInsight() {
        startTest("Verify quick links Fleet Insight tab", "Click on Fuel Services CTA, user will navigate user to vehicle one view on Fleet Monitor -> Fleet Insights with vehicle selected. ");
        getFleetTrackingScreen().validateOneVehicleDetails().
                quickLinksTabFleetInsight();
    }











}
