@Regresion
Feature: Verificar el funcionamiento de la pantalla de simulación de Canon Financiero
  expuesta por el grupo Bancolombia, en cuanto a la presentación de los valores calculados.

  @CasoExitoso
  Scenario Outline: Diligenciar el formulario de simulación correctamente y verificar que
    los siguientes campos se devuelvan por el sistema: Valor canon mensual, Tasa efectiva anual,
    Tasa nominal anual mes vencida,  Valor de la opción de compra, Porcentaje de la opción de compra.

    Given Que navego en el portal para presentar el formulario Simulador de canon financiero
    When Diligencio el formulario
      | <ValorActivoIncluyeIVA> | <PlazoContrato> | <PorcentajeOpcionCompra> | <TipoTasa> | <Modalidad> |
    Then Presento el resultado de la simulacion

    Examples: 
      | ValorActivoIncluyeIVA | PlazoContrato | PorcentajeOpcionCompra | TipoTasa | Modalidad |
      |              10000000 |            12 |                      1 | DTF      | Vencida   |

  @CasoAlterno
  Scenario Outline: Diligenciar el formulario de simulación con datos erroneos y verificar que
    se despliegue mensaje de advertencia

    Given Que navego en el portal para presentar el formulario Simulador de canon financiero
    When Diligencio el formulario
      | <ValorActivoIncluyeIVA> | <PlazoContrato> | <PorcentajeOpcionCompra> | <TipoTasa> | <Modalidad> |
    Then Verifico mensaje de error

    Examples: 
      | ValorActivoIncluyeIVA | PlazoContrato | PorcentajeOpcionCompra | TipoTasa | Modalidad |
      |                       |               |                        |          | Vencida   |
      |                     1 |             1 |                     -1 |          | Vencida   |
      |         1000000000000 |           121 |                     11 |          | Vencida   |
