$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Orders.feature");
formatter.feature({
  "line": 2,
  "name": "TBL Product \u0026 SKU download",
  "description": "",
  "id": "tbl-product-\u0026-sku-download",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Orders"
    }
  ]
});
formatter.scenarioOutline({
  "line": 4,
  "name": "",
  "description": "Lazada user is able to download TBL product and SKU details",
  "id": "tbl-product-\u0026-sku-download;",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "Customer opens the homepage for the \"\u003cURL\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Customer login to system by providing \"\u003cEmail\u003e\" and \"\u003cPassword\u003e\"",
  "keyword": "When "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "tbl-product-\u0026-sku-download;;",
  "rows": [
    {
      "cells": [
        "URL",
        "Email",
        "Password"
      ],
      "line": 11,
      "id": "tbl-product-\u0026-sku-download;;;1"
    },
    {
      "cells": [
        "https://sellercenter.lazada.sg/apps/seller/login",
        "amitrs@specom.io",
        "Singpost123456"
      ],
      "line": 12,
      "id": "tbl-product-\u0026-sku-download;;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 119106900,
  "status": "passed"
});
formatter.before({
  "duration": 423300,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "",
  "description": "Lazada user is able to download TBL product and SKU details",
  "id": "tbl-product-\u0026-sku-download;;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@Orders"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Customer opens the homepage for the \"https://sellercenter.lazada.sg/apps/seller/login\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Customer login to system by providing \"amitrs@specom.io\" and \"Singpost123456\"",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "https://sellercenter.lazada.sg/apps/seller/login",
      "offset": 37
    }
  ],
  "location": "GivenStepDefinition.Open_homepage(String)"
});
formatter.result({
  "duration": 2293698500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "amitrs@specom.io",
      "offset": 39
    },
    {
      "val": "Singpost123456",
      "offset": 62
    }
  ],
  "location": "WhenStepDefinition.customer_login_by_providing_email_password(String,String)"
});
formatter.result({
  "duration": 54669850100,
  "status": "passed"
});
formatter.after({
  "duration": 219600,
  "status": "passed"
});
});