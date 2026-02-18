package org.example;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;



public class Main {
    public static void main(String[] args) {
        String textoQR = "https://static.wikia.nocookie.net/onepiece/images/7/75/One_Piece_Logo.png/revision/latest?cb=20120706185846&path-prefix=es";

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

    /**
     * Genera un código QR y lo guarda como imagen PNG
     *
     * @param texto Texto o URL a codificar
     * @param rutaArchivo Ruta donde guardar la imagen
     * @param ancho Ancho de la imagen en píxeles
     * @param alto Alto de la imagen en píxeles
     */
    public static void generarCodigoQR(String texto, String rutaArchivo, int ancho, int alto)
            throws WriterException, IOException {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(texto, BarcodeFormat.QR_CODE, ancho, alto);


        int colorNegro = 0xFF000000;
        int colorTransparente = 0x00000000;

        BufferedImage imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                imagen.setRGB(x, y, bitMatrix.get(x, y) ? colorNegro : colorTransparente);
            }
        }

        File archivoSalida = new File(rutaArchivo);
        ImageIO.write(imagen, "PNG", archivoSalida);
    }
}