package tests;

import pageObjects.FleetTrackingScreen;
import pageObjects.FleetTrackingScreenV1;
import pageObjects.LandingPage;

public class GetPage extends SuiteSetup{
    FleetTrackingScreen fleetTrackingScreen;
    LandingPage landingPage;

    FleetTrackingScreenV1 fleetTrackingScreenV1;

    public FleetTrackingScreenV1 getFleetTrackingScreenV1() {
        if (fleetTrackingScreenV1 == null) {
            fleetTrackingScreenV1 = new FleetTrackingScreenV1(factory.getDriver());
        }
        return fleetTrackingScreenV1;
    }
    public FleetTrackingScreen getFleetTrackingScreen(){
        if(fleetTrackingScreen==null){
            fleetTrackingScreen=new FleetTrackingScreen(factory.getDriver());
        }
        return fleetTrackingScreen;
    }


    public LandingPage getLandingPage(){
        if(landingPage==null){
            landingPage=new LandingPage(factory.getDriver());
        }
        return landingPage;
    }
}
