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

### Compilación y ejecución

```bash
# Con Maven
mvn clean compile
mvn exec:java -Dexec.mainClass="org.example.Main"

# Con Gradle
gradle build
gradle run
```

### Uso básico

El método principal genera un código QR de 300x300 píxeles con fondo transparente:

```java
public static void main(String[] args) {
    String textoQR = "https://www.ejemplo.com";
    String rutaArchivo = "codigo_qr.png";
    int ancho = 300;
    int alto = 300;
    
    try {
        generarCodigoQR(textoQR, rutaArchivo, ancho, alto);
        System.out.println("¡Código QR generado exitosamente en: " + rutaArchivo);
    } catch (WriterException | IOException e) {
        System.err.println("Error al generar el código QR: " + e.getMessage());
        e.printStackTrace();
    }
}
```

### Método principal

```java
public static void generarCodigoQR(String texto, String rutaArchivo, int ancho, int alto)
```

**Parámetros:**
- `texto`: Contenido a codificar en el QR (URL, texto, etc.)
- `rutaArchivo`: Ruta donde se guardará la imagen PNG
- `ancho`: Ancho de la imagen en píxeles
- `alto`: Alto de la imagen en píxeles

### Ejemplos de contenido para codificar

**URL:**
```java
String textoQR = "https://www.miempresa.com";
```

**Texto simple:**
```java
String textoQR = "Hola Mundo desde QR!";
```

**Número de teléfono:**
```java
String textoQR = "tel:+584121234567";
```

**Email:**
```java
String textoQR = "mailto:contacto@ejemplo.com";
```

**vCard (Tarjeta de contacto):**
```java
String textoQR = "BEGIN:VCARD\nVERSION:3.0\nFN:Juan Pérez\nTEL:+584121234567\nEMAIL:juan@ejemplo.com\nEND:VCARD";
```

**WiFi:**
```java
String textoQR = "WIFI:T:WPA;S:NombreRed;P:contraseña;;";
```

**Coordenadas GPS:**
```java
String textoQR = "geo:10.4806,-66.9036";
```

## ⚙️ Personalización

### Cambiar el tamaño del QR

Modifica las variables `ancho` y `alto` en el método `main`:

```java
int ancho = 500;  // Ancho en píxeles
int alto = 500;   // Alto en píxeles
```

### Cambiar el color del QR

Modifica la variable `colorNegro` en el método `generarCodigoQR`:

```java
// Negro (por defecto)
int colorNegro = 0xFF000000;

// Rojo
int colorNegro = 0xFFFF0000;

// Azul
int colorNegro = 0xFF0000FF;

// Verde
int colorNegro = 0xFF00FF00;

// Morado
int colorNegro = 0xFF800080;
```

### Cambiar el color de fondo

Si no deseas fondo transparente, modifica `colorTransparente`:

```java
// Transparente (por defecto)
int colorTransparente = 0x00000000;

// Blanco
int colorTransparente = 0xFFFFFFFF;

// Gris claro
int colorTransparente = 0xFFEEEEEE;

// Amarillo suave
int colorTransparente = 0xFFFFF9C4;
```

### Cambiar la ruta de salida

```java
// Ruta relativa (en el directorio del proyecto)
String rutaArchivo = "codigo_qr.png";

// Ruta absoluta
String rutaArchivo = "/home/usuario/documentos/qr.png";

// Ruta en Windows
String rutaArchivo = "C:\\Users\\usuario\\Desktop\\qr.png";
```

## 📁 Estructura del proyecto

```
qr-generator/
│
├── src/
│   └── main/
│       └── java/
│           └── org/
│               └── example/
│                   └── Main.java
│
├── pom.xml (o build.gradle)
├── codigo_qr.png (generado al ejecutar)
└── README.md
```

## 🔍 Detalles técnicos

### Formato de color ARGB

Los colores se definen en formato hexadecimal ARGB de 32 bits:

```
0xAARRGGBB
  │ │ │ └─ Blue (00-FF)
  │ │ └─── Green (00-FF)
  │ └───── Red (00-FF)
  └─────── Alpha/Opacidad (00=transparente, FF=opaco)
```

**Ejemplos:**
- `0xFF000000` = Negro opaco
- `0x00000000` = Transparente
- `0xFFFF0000` = Rojo opaco
- `0x80FF0000` = Rojo semi-transparente

### Especificaciones técnicas

- **Formato de salida:** PNG (requerido para transparencia)
- **Tipo de imagen:** BufferedImage.TYPE_INT_ARGB (soporte de canal alpha)
- **Formato de código QR:** BarcodeFormat.QR_CODE (ZXing)
- **Librería:** ZXing 3.5.3
- **Package:** org.example

## 📝 Notas importantes

1. **Formato PNG obligatorio:** El archivo de salida debe ser PNG para mantener la transparencia. JPG no soporta canal alpha.

2. **Tamaño recomendado:** Para códigos QR legibles, se recomienda un mínimo de 200x200 píxeles. Para imprimir, usar al menos 300x300 píxeles.

3. **Longitud del contenido:** Los códigos QR tienen límites de capacidad:
   - Numérico: hasta 7,089 caracteres
   - Alfanumérico: hasta 4,296 caracteres
   - Binario: hasta 2,953 bytes

4. **Manejo de errores:** El código captura excepciones de escritura (`WriterException`) y de I/O (`IOException`).

## 💡 Casos de uso

- Generación de códigos QR para URLs de productos
- Tarjetas de presentación digitales (vCard)
- Información de contacto rápido
- Acceso a redes WiFi
- Pagos y transacciones
- Ubicaciones GPS
- Autenticación de dos factores

## 🐛 Troubleshooting

### Error: "No encoder available for format QR_CODE"
Asegúrate de tener ambas dependencias de ZXing: `core` y `javase`.

### Error: "Could not write an image of format PNG"
Verifica que la ruta de destino exista y tengas permisos de escritura.

### El QR no se escanea correctamente
- Verifica que el tamaño sea al menos 200x200 píxeles
- Asegúrate de que el contraste entre el QR y el fondo sea suficiente
- Revisa que el contenido no exceda la capacidad del código QR

## 👨‍💻 Autor

Desarrollado por Ophy
