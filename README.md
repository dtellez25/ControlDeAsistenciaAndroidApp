# Aplicacion de Control de Asistencia con Android Studio

## Descripción

La aplicación de seguimiento de asistencia es una herramienta diseñada para facilitar el control de la asistencia de los empleados en una empresa. Esta aplicación permite a los administradores y supervisores marcar la asistencia de los empleados de manera rápida y eficiente utilizando un dispositivo Android.

## Características

- **Lista de Empleados**: La aplicación muestra una lista de todos los empleados registrados en la base de datos.
- **Perfil Detallado**: Al seleccionar un empleado de la lista, se puede acceder a su perfil detallado, que incluye su nombre, apellido, posición y un código de empleado.
- **Marcado de Asistencia**: Los empleados pueden ingresar un código de asistencia y marcar su asistencia. Si el código es correcto, la aplicación confirma el marcado de asistencia.
- **Cambio de Estado Visual**: Una vez marcada la asistencia correctamente, el estado visual del empleado cambia en la lista (de un círculo rojo a un círculo verde).

## Uso

1. **Visualización de Empleados**: Al iniciar la aplicación, se muestra una lista de empleados.
2. **Seleccionar Empleado**: Toque un empleado para ver su perfil detallado.
3. **Marcar Asistencia**: Ingrese el código de asistencia y presione el botón de enviar. Si el código es correcto, la asistencia se marcará y el círculo rojo junto al nombre del empleado cambiará a verde.

## Estructura del Proyecto

- `MainActivity.java`: Controla la vista principal que muestra la lista de empleados.
- `detailedActivity.java`: Controla la vista detallada de cada empleado y el marcado de asistencia.
- `EmpleadoController.java`: Maneja la lógica de negocio, incluyendo la obtención de datos de la base de datos y el marcado de asistencia.
- `ModeloEmpleado.java`: Define el modelo de datos para los empleados.
- `empleadoAdapter.java`: Adaptador para enlazar los datos de los empleados con la vista de RecyclerView.

## Vistas

- `activity_main.xml`: Layout de la actividad principal que muestra la lista de empleados.
- `empleado_detallado.xml`: Layout de la actividad detallada de cada empleado.
- `recycler_view_item.xml`: Layout para cada ítem en la lista de empleados.

## Recursos

- `drawable/`: Contiene los recursos gráficos como el logo y los círculos de estado (rojo y verde).
- `values/strings.xml`: Contiene las cadenas de texto usadas en la aplicación.
- `values/colors.xml`: Define los colores usados en la aplicación.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir a este proyecto, por favor, abre un issue o envía un pull request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Para más detalles, consulta el archivo LICENSE.
