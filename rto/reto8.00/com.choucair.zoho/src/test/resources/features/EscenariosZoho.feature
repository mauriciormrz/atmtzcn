#Author: your.email@your.domain.com
@Regresion
Feature: Trabajar con el CRM Zoho
  Registro y creacion tarea Zoho

  @RegistroUsuario
  Scenario Outline: Registro exitoso Zoho
    Given que yo quiero utilizar el CRM Zoho
    When realizo el registro exitoso
      | <nombre_completo> | <correo_electronico> | <contrasegna> | <pais> | <nombre_empresa> | <telefono> | <zona_horaria> | <idioma> | <moneda_local> |
    Then verifico el acceso a la aplicación

    Examples: 
      | nombre_completo  | correo_electronico             | contrasegna     | pais          | nombre_empresa | telefono   | zona_horaria                                  | idioma  | moneda_local |
      | Mauricio Ramirez | ramirezmauricio...@hotmail.com | ramirezmauricio | United States | Enlace GPS     | 3003206240 | (GMT -5:0 ) Hora de Colombia( America/Bogota ) | español | Colombia     |

  @CreacionTarea
  Scenario Outline: Creo una tarea Zoho
    Given que ingreso al CRM Zoho con un usuario registrado
    When realizo la creacion de una tarea
      | <nombre_completo> | <correo_electronico> | <contrasegna> | <pais> | <nombre_empresa> | <telefono> | <zona_horaria> | <idioma> | <moneda_local> |
    Then verifico la tarea creada exitosamente

    Examples: 
      | nombre_completo  | correo_electronico             | contrasegna     | pais    | nombre_empresa | telefono   | zona_horaria                                  | idioma  | moneda_local |
      | Mauricio Ramirez | ramirezmauricio...@hotmail.com | ramirezmauricio | Comoros | Enlace GPS     | 3003206240 | (GMT -5:0) Hora de Colombia( America/Bogota ) | español | Colombia     |

