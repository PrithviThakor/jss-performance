package org.bahmni.gatling.scenarios


import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import org.bahmni.gatling.Configuration
import org.bahmni.gatling.HttpRequests._
import io.gatling.http.Predef._

/**
  * Created by swarup on 12/20/16.
  */
object PatientCreateAndStartVisitFlow {


  val createPatient : ChainBuilder = exec (
    createPatientRequest
      .check(
        jsonPath("$.patient.uuid").saveAs("patient_uuid"),
        status.is(200)
      ).resources(
          startVisitRequest("${patient_uuid}").check(status.is(201)),
          getPatient("${patient_uuid}")
        )


  )

  val scn : ScenarioBuilder = scenario("create Patient and start visit")
    .during(Configuration.Load.DURATION){
      exec(createPatient)
    }
}
