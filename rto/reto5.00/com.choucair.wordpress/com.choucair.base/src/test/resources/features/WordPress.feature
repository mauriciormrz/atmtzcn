@Regresion
Feature: Creacion y puesta en linea de un sitio web.


  @CasoExitoso
  Scenario Outline: Creacion y puesta en linea de un sitio web.
    Given Que navego en el portal para presentar los formularios
    When Diligencio el formulario paso uno
      | <NombreSitio> | <TemaSitio> |
    And Diligencio el formulario paso dos
      | <NombreBuscarSitio> |
    And Diligencio el formulario paso tres
    And Diligencio el formulario paso cuatro
      | <Correo> | <NombreUsuario> | <Contraseña> |
    Then Verifico la creación del sitio exitoso
      | <NombreSitio> |

    Examples: 
      | NombreSitio    | TemaSitio    | NombreBuscarSitio     | Correo                 | NombreUsuario    | Contraseña   |
      | Nombre_Sitio_1 | Tema_Sitio_1 | Nombre_Buscar_Sitio_1 | correo_1_...@gmail.com | Nombre_Usuario_1 | Contraseña_1 |
      | Nombre_Sitio_2 | Tema_Sitio_2 | Nombre_Buscar_Sitio_2 | correo_2_...@gmail.com | Nombre_Usuario_2 | Contraseña_2 |
