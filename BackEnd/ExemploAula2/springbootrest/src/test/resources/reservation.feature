Feature: the message can be retrieved
  Scenario: client makes call to POSTS /v1/reservations
    When the client calls /v1/reservations
    Then the client receives status code of 200
    And the client receives server version hello
  Scenario: client makes call to GET /v1/reservations
    Given the client calls /v1/reservations
    When the client receives status code of 200
    Then the client receives server version hello