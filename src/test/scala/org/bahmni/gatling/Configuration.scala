package org.bahmni.gatling

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Configuration {

  object Constants {
    val BASE_HTTPS_URL = "https://product-qa09.mybahmni.org"
    val BASE_HTTP_URL = "http://localhost:9001"
    val LOGIN_USER = "superman"
    val LOGIN_USER_UUID = "cac3a2c0-4929-4103-90da-de7f99573aab"
    val PROVIDER_UUID = "d390d057-ec33-45c1-8342-9e23d706aa4d"
    val LOGIN_LOCATION_UUID = "b4831eb8-c79a-11e2-b284-107d46e7b2c5"
    val PATIENT_IDENTIFIER = "GAN179326"
    val PATIENT_IDENTIFIER1 = "SIV156624"
    val PATIENT_IDENTIFIER2 = "BAM118663"
    /*val PATIENT_IDENTIFIER = "Sujan Singh"
    val PATIENT_IDENTIFIER1 = "Nidhi"
    val PATIENT_IDENTIFIER2 = "kirtanjli"*/
    val PATIENT_UUID = "727ab416-4916-40b3-bd00-b116e73f7cd9"
    val VISIT_UUID = "33132f71-5f07-49a6-bdc5-f6ba240dcfd7"
    val ANOTHER_PATIENT_UUID = "08047a4e-bb16-42a3-ab0a-b83674756d62"
    val ANOTHER_VISIT_UUID = "71a7e789-1741-44f5-b54e-42e88c3b8e82"
    //val RADIOLOGY_ORDER_TYPE_UUID = "244b43be-28f1-11e4-86a0-005056822b0b" // possible DB
    val RADIOLOGY_ORDER_TYPE_UUID = "8189dbdd-3f10-11e4-adec-0800271c1b75"
    val USG_ORDER_TYPE_UUID = "c39840d9-57a1-11e6-8158-d4ae52d4c69b"
    var ENCOUNTER_TYPE_UUID = "24482b92-28f1-11e4-86a0-005056822b0b"
    var ATOMFEED_ENCOUNTER_UUID = "1b5e768d-3c07-4bfb-8195-cc1f768d29d6"
    //val ALL_TESTS_AND_PANELS ="24d98284-28f1-11e4-86a0-005056822b0b" //possible DB
    val ALL_TESTS_AND_PANELS ="e4edc5a4-e349-11e3-983a-91270dcbd3bf"
  }

  object HttpConf {
    val HTTPS_PROTOCOL = http
      .baseURL(Configuration.Constants.BASE_HTTPS_URL)

      .inferHtmlResources()
      .basicAuth("superman", "Admin123")
      .acceptHeader("application/json, text/plain, */*")
      .acceptEncodingHeader("gzip, deflate, sdch, br")
      .acceptLanguageHeader("en-US,en;q=0.8")
      .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
    val HTTP_PROTOCOL = http
      .baseURL("http://localhost:9001")

      .inferHtmlResources()
      .basicAuth("superman", "Admin123")
      .acceptHeader("application/json, text/plain, */*")
      .acceptEncodingHeader("gzip, deflate, sdch, br")
      .acceptLanguageHeader("en-US,en;q=0.8")
      .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
  }

  object Load {
    var ATOMFEED_USER_PROFILE = rampUsers(3) over 10
    var DURATION = 600
  }

}