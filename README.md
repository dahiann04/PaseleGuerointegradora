# Pásele Güero – Marketplace Móvil

> *Proyecto Integrador - Desarrollo de Aplicaciones Móviles*  
> *Semestre:* 4°E  
> *Fecha de entrega:* 12 de Diciembre

---

##  Equipo de Desarrollo

| Nombre Completo | Rol / Tareas Principales | GitHub |
| :--- | :--- | :--- |
| Ayala Benitez Dahiane Paulina | MODEL, NAVIGATION Y COMPONENTS | dahiann04 |
| Roldan Andrade Juan Pablo | SCREEN, VIEWMODEL | JuanPabloRA139 |
| Ortiz Martinez Martin | NETWORK, REPOSITORY | Martin111006 |

---

##  Descripción del Proyecto

**¿Qué hace la aplicación?**  
Pásele Güero es una aplicación móvil tipo marketplace, diseñada para facilitar la venta de productos mediante una interfaz moderna desarrollada con **Kotlin** y **Jetpack Compose**.  
El proyecto integra funcionalidades esenciales como captura de imágenes, gestión de archivos, navegación por pantallas y manejo de datos locales, con el objetivo de digitalizar procesos de venta de manera práctica y accesible.

**Objetivo:**  
Crear una app funcional usando Kotlin y Jetpack Compose.

Implementar una estructura modular y fácil de mantener.

Integrar cámara, captura de imágenes, lectura/escritura de archivos, y almacenamiento local.

Diseñar una interfaz intuitiva y accesible.

Manejar navegación limpia en Compose.

Implementar comunicación con servicios mediante API REST.


---

##  Stack Tecnológico y Características

Este proyecto ha sido desarrollado siguiendo buenas prácticas y la arquitectura **MVVM**, integrando funcionalidades modernas de Android:

- **Lenguaje:** Kotlin 100%.
- **Interfaz de Usuario:** Jetpack Compose.
- **Arquitectura:** MVVM (Model-View-ViewModel).
- **Navegación:** Compose Navigation para un flujo de pantallas limpio y modular.
- **Conectividad (API REST):** Retrofit o Ktor según implementación.
  - **GET:** Obtiene todos los productos almacenados.
  - **POST:** Agrega nuevos productos con su información.
  - **UPDATE:** Actualiza la información de los productos existentes.
  - **DELETE:** Elimina productos según lo requiera el usuario.
- **Captura de imágenes:** CameraX y MediaStore para tomar y almacenar fotos de productos.
- **Gestión de información local:** Persistencia mediante archivos, Room o SharedPreferences.
- **Funciones auxiliares:** Manejo de rutas, validaciones, procesamiento básico de imágenes y gestión de recursos internos.
- **Interfaz accesible y dinámica:** Componentes visuales claros y fáciles de navegar.

---

##  Sensores Utilizados

### Sensor de Cámara
- **Tipo:** Cámara del dispositivo
- **Permiso requerido:**  

```xml
<uses-permission android:name="android.permission.CAMERA" />
<uses-feature android:name="android.hardware.camera.any" />

---

##  Descarga e Instalación del APK

El ejecutable de la aplicación (.apk) se encuentra disponible para descarga desde la sección de **Releases** de este repositorio.  

**Descripción formal para la descarga:**  
La descarga del APK permite a los usuarios instalar directamente la aplicación en sus dispositivos Android, sin necesidad de compilar el proyecto desde el código fuente. Esta opción está destinada a probar, evaluar y utilizar Pásele Güero de manera inmediata, facilitando la gestión y venta de productos a través de un marketplace moderno de subastas.  
Al instalar el APK, el usuario podrá:  

- Registrar y visualizar productos con imágenes.  
- Administrar información de manera local y persistente.  
- Navegar entre pantallas de forma intuitiva gracias a Compose Navigation.  
- Probar funcionalidades integradas como la captura de imágenes y el almacenamiento interno.  

2. Descarga el archivo `.apk` de la última versión.  
3. Habilita la instalación de **orígenes desconocidos** en tu dispositivo Android si es necesario.  
4. Abre el archivo descargado e instala la aplicación.  
5. Concede los permisos solicitados (cámara, almacenamiento) para su correcto funcionamiento.  

> Nota: Esta versión del APK está destinada únicamente para evaluación académica y pruebas de la aplicación.
