package org.bahmni.gatling.simulations

import io.gatling.core.Predef._
import org.bahmni.gatling.Configuration.HttpConf._
import org.bahmni.gatling.Configuration.Load
import org.bahmni.gatling.scenarios._

class UserSimulation extends Simulation {

  setUp(
    Clinical_Dashboard_View_Name_Search_Flow.scn.inject(rampUsers(50) over 150).protocols(HTTPS_PROTOCOL),
    //Clinical_Dashboard_View_Name_Search_Flow.scn.inject(rampUsersPerSec(1) to (1) during (1200)).protocols(HTTPS_PROTOCOL)
    Registration_Exact_Search_Flow.scn.inject(rampUsers(1) over 300).protocols(HTTPS_PROTOCOL),
    Registration_Name_Search_Flow.scn.inject(rampUsers(3) over 60).protocols(HTTPS_PROTOCOL),
    PatientCreateAndStartVisitFlow.scn.inject(rampUsers(1) over 210).protocols(HTTPS_PROTOCOL),
    PatientImage.scn.inject(splitUsers(1200) into(rampUsers(20) over 10) separatedBy(5)).protocols(HTTP_PROTOCOL),
    AdtFlow.scn.inject(rampUsers(2) over 20).protocols(HTTPS_PROTOCOL),
    AtomfeedScenarios.patientFeed.inject(Load.ATOMFEED_USER_PROFILE).protocols(HTTP_PROTOCOL),
    AtomfeedScenarios.patientFeedContent.inject(Load.ATOMFEED_USER_PROFILE).protocols(HTTP_PROTOCOL),
    AtomfeedScenarios.encounterFeed.inject(Load.ATOMFEED_USER_PROFILE).protocols(HTTP_PROTOCOL),
    AtomfeedScenarios.encounterFeedContent.inject(Load.ATOMFEED_USER_PROFILE).protocols(HTTP_PROTOCOL),
    AtomfeedScenarios.labFeed.inject(Load.ATOMFEED_USER_PROFILE).protocols(HTTP_PROTOCOL),
    AtomfeedScenarios.labFeedContent.inject(Load.ATOMFEED_USER_PROFILE).protocols(HTTP_PROTOCOL)
  )
    .assertions(
	global.successfulRequests.percent.gte(90),
	details("Search Patient by Identifier").responseTime.percentile3.lte(61000),
	details("Search Patient by Name").responseTime.percentile3.lte(41000),
	details("getVisits").responseTime.percentile3.lte(4000),
	details("get lab order results").responseTime.percentile3.lte(17000),
	details("get diagnoses for patient").responseTime.percentile3.lte(7000),
	details("create patient").responseTime.percentile3.lte(17000),
	details("get obs").responseTime.percentile3.lte(3000)
    )
}
