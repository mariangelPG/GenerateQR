# Generador de Códigos QR en Java

Aplicación sencilla en Java para generar códigos QR con fondo transparente utilizando la librería ZXing (Zebra Crossing).

## 📋 Características

- Generación de códigos QR a partir de cualquier texto o URL
- Fondo transparente para fácil integración en diseños
- Tamaño personalizable
- Salida en formato PNG con soporte de transparencia
- Código limpio y fácil de integrar en otros proyectos

## 🛠️ Requisitos

- Java 8 o superior
- Maven o Gradle (para gestión de dependencias)

## 📦 Dependencias

Este proyecto utiliza la librería ZXing para la generación de códigos QR.

### Maven (pom.xml)

```xml
<dependencies>
    <dependency>
        <groupId>com.google.zxing</groupId>
        <artifactId>core</artifactId>
        <version>3.5.3</version>
    </dependency>
    <dependency>
        <groupId>com.google.zxing</groupId>
        <artifactId>javase</artifactId>
        <version>3.5.3</version>
    </dependency>
</dependencies>
```

### Gradle (build.gradle)

```gradle
dependencies {
    implementation 'com.google.zxing:core:3.5.3'
    implementation 'com.google.zxing:javase:3.5.3'
}
```

## 🚀 Uso

### Uso básico

```java
public static void main(String[] args) {
    String textoQR = "https://www.ejemplo.com";
    String rutaArchivo = "codigo_qr.png";
    int ancho = 300;
    int alto = 300;
    
    try {
        generarCodigoQRTransparente(textoQR, rutaArchivo, ancho, alto);
        System.out.println("¡Código QR generado exitosamente!");
    } catch (WriterException | IOException e) {
        e.printStackTrace();
    }
}
```

### Ejemplos de contenido para codificar

**URL:**
```java
String textoQR = "https://www.miempresa.com";
```

**Texto simple:**
```java
String textoQR = "Hola Mundo!";
```

**Número de teléfono:**
```java
String textoQR = "tel:+584121234567";
```

**Email:**
```java
String textoQR = "mailto:contacto@ejemplo.com";
```

**WiFi:**
```java
String textoQR = "WIFI:T:WPA;S:NombreRed;P:contraseña;;";
```

## ⚙️ Personalización

### Cambiar el tamaño del QR

```java
int ancho = 500;  // Ancho en píxeles
int alto = 500;   // Alto en píxeles
```

### Cambiar el color del QR

Modifica la variable `colorNegro` en el método `generarCodigoQRTransparente`:

```java
// Negro (por defecto)
int colorNegro = 0xFF000000;

// Rojo
int colorNegro = 0xFFFF0000;

// Azul
int colorNegro = 0xFF0000FF;

// Verde
int colorNegro = 0xFF00FF00;
```

### Cambiar el color de fondo

Si no deseas fondo transparente, puedes modificar `colorTransparente`:

```java
// Transparente (por defecto)
int colorTransparente = 0x00000000;

// Blanco
int colorTransparente = 0xFFFFFFFF;

// Gris claro
int colorTransparente = 0xFFEEEEEE;
```

## 🔍 Detalles técnicos

- **Formato de salida:** PNG (requerido para transparencia)
- **Tipo de imagen:** BufferedImage.TYPE_INT_ARGB (soporte de canal alpha)
- **Formato de color:** ARGB (Alpha, Red, Green, Blue)
- **Librería:** ZXing 3.5.3

## 📝 Notas importantes

- El archivo de salida **debe ser PNG** para mantener la transparencia. Formatos como JPG no soportan transparencia.
- Los valores de color usan formato hexadecimal ARGB donde:
  - Los primeros 2 dígitos (FF) representan la opacidad (00 = transparente, FF = opaco)
  - Los siguientes 6 dígitos representan el color RGB

## 👨‍💻 Autor

Desarrollado por Ophy

