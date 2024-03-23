import static org.junit.Assert.assertEquals;

import java.awt.Color;

public class prueba {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		tests();
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.println("Tiempo transcurrido: " + elapsedTime + " milisegundos");
	}
  
    static void tests() {
        assertEquals("For input: (0, 0, 0)", "000000", RgbToHex.rgb(0, 0, 0));
        assertEquals("For input: (1, 2, 3)", "010203", RgbToHex.rgb(1, 2, 3));
        assertEquals("For input: (255, 255, 255)", "FFFFFF", RgbToHex.rgb(255, 255, 255));
        assertEquals("For input: (254, 253, 252)", "FEFDFC", RgbToHex.rgb(254, 253, 252));
        assertEquals("For input: (-20, 275, 125)", "00FF7D", RgbToHex.rgb(-20, 275, 125));
    }

}

class RgbToHex {

    public static String rgb(int r, int g, int b) {
    	int [] rgbArray= {r,g,b};
    	for (int i = 0; i<rgbArray.length; i++) {
    		if (rgbArray[i] > 255) 	{rgbArray[i] = 255;}
    		if (rgbArray[i] < 0) 	{rgbArray[i] = 0;}
    	}
    	Color yourColor = new Color(rgbArray[0], rgbArray[1], rgbArray[2]);
    	String hex = Integer.toHexString(yourColor.getRGB()).substring(2);
    	return hex.toUpperCase();
    }
}

//The rgb function is incomplete. Complete it so that passing in RGB decimal values will result in a hexadecimal representation being returned. Valid decimal values for RGB are 0 - 255. Any values that fall out of that range must be rounded to the closest valid value.
//
//Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.
//
//Examples (input --> output):
//255, 255, 255 --> "FFFFFF"
//255, 255, 300 --> "FFFFFF"
//0, 0, 0       --> "000000"
//148, 0, 211   --> "9400D3"