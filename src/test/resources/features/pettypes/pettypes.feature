@gestionarTiposMascotas
Feature:  Gestionar mascotas

  @listarTiposMascotas
  Scenario: Listar mascotas
    Given cliente con recurso "pet/findByStatus", query "status=available", header "application/json"
    When el cliente hace una solicitud GET
    Then el servidor debe de responder con un status 200
    And el cuerpo de la respuesta debe de ser una lista de tipos de mascotas

  Scenario: Obtener mascota por id 4
    Given el cliente tiene configurado el recurso "pet/4" con header "application/json"
    When el cliente hace una solicitud GET
    Then el servidor debe de responder con un status 200

  Scenario: Obtener mascota por id 5
    Given el cliente tiene configurado el recurso "pet/5" con header "application/json"
    When el cliente hace una solicitud GET
    Then el servidor debe de responder con un status 200

  Scenario: Obtener mascota por id 6
    Given el cliente tiene configurado el recurso "pet/6" con header "application/json"
    When el cliente hace una solicitud GET
    Then el servidor debe de responder con un status 200

  @obtenerTiposMascotaPorId
  Scenario Outline: Obtener mascota por id
#  Scenario Outline: Obtener mascota por <id>
    Given el cliente tiene configurado el recurso <path> con header "application/json"
    When el cliente hace una solicitud GET
    Then el servidor debe de responder con un status <statusCode>
    And el cuerpo de la respuesta contiene la propiedad id con el valor <id>
    And el cuerpo de la respuesta contiene la propiedad name con el valor <name>
    Examples:
      | path    | statusCode | id | name     |
      | "pet/4" | 200        | 4  | "Dog 1"  |
      | "pet/5" | 200        | 5  | "doggie" |
      | "pet/6" | 200        | 6  | "Dog 3"  |