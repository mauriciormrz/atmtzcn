@Regresion
Feature: Consultar la información de las tarjetas de crédito American Express Green y MasterCard Black.  Solicitar la tarjeta American Express.

  @CasoExitoso
  Scenario Outline: Desplegar por consola la información de las tarjetas American Express Green y MasterCard Black y diligenciar el formulario de solicitud de la tarjeta   American Express.
    Given Que navego en el portal para ir la opcion tarjetas de credito
    When Consulto la informacion de las tarjetas de credito
    Then Solicito la tarjeta American Express
      | <Nombres> | <Apellidos> | <TipoDocumento> | <NroDocumento> | <FechaNacimiento> | <IngresosMensuales> | <Residencia> |

    Examples: 
      | Nombres  | Apellidos        | TipoDocumento        | NroDocumento | FechaNacimiento | IngresosMensuales | Residencia           |
      | Mauricio | Ramirez Restrepo | Cédula de Ciudadanía |     98548330 | 1969-08-10      |        2600000.00 | Envigado - Antioquia |

  @CasoAlterno
  Scenario Outline: Diligenciar el formulario de simulación con datos erroneos y verificar que
    se despliegue mensaje de advertencia.

    Given Que navego en el portal para ir la opcion tarjetas de credito
    When Consulto la informacion de las tarjetas de credito
    Then Verifico los mensajes de error
      | <Nombres> | <Apellidos> | <TipoDocumento> | <NroDocumento> | <FechaNacimiento> | <IngresosMensuales> | <Residencia> |

    Examples: 
      | Nombres  | Apellidos        | TipoDocumento        | NroDocumento | FechaNacimiento | IngresosMensuales | Residencia           |
      | Mauricio | Ramirez Restrepo | Cédula de Ciudadanía |     98548330 | 1969-08-10      |        2600000.00 | Envigado - Antioquia |
