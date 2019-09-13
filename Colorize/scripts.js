
/* CON QUESTA FUNZIONE SI ESCLUDE IL DATABASE IN QUESTO CASO */
function myFunction1() {
    document.getElementById("demo").innerHTML = "Aqua is a greenish-blue color, a variation of the color cyan. The web color aqua is identical to the web color cyan, also sometimes called electric cyan.";
}

function myFunction2() {
    document.getElementById("demo").innerHTML = "Black is the darkest color, the result of the absence or complete absorption of visible light. It is an achromatic color, a color without hue, like white.";
}

function myFunction3() {
    document.getElementById("demo").innerHTML = "Blue is one of the three primary colours of pigments in painting and traditional colour theory, as well as in the RGB colour model. It lies between violet and green on the spectrum of visible light. The eye perceives blue when observing light with a dominant wavelength between approximately 450 and 495 nanometres.";
}

function myFunction4() {
    document.getElementById("demo").innerHTML = "Fuchsia is a vivid purplish red color, named after the color of the flower of the fuchsia plant, which took its name from the 16th century German botanist Leonhart Fuchs. The color fuchsia was first introduced as the color of a new aniline dye called fuchsine, patented in 1859 by the French chemist François-Emmanuel Verguin.";
}

function myFunction5() {
    document.getElementById("demo").innerHTML = "Grey (British English) or gray (American English;) is an intermediate color between black and white. It is a neutral color or achromatic color, meaning literally that it is a color 'without color', because it can be composed of black and white. It is the color of a cloud-covered sky, of ash and of lead. ";
}

function myFunction6() {
    document.getElementById("demo").innerHTML = "Green is the color between blue and yellow on the visible spectrum. It is evoked by light which has a dominant wavelength of roughly 495–570 nm. In subtractive color systems, used in painting and color printing, it is created by a combination of yellow and blue, or yellow and cyan; in the RGB color model, used on television and computer screens, it is one of the additive primary colors, along with red and blue, which are mixed in different combinations to create all other colors. ";
}


function myFunction7() {
    document.getElementById("demo").innerHTML = "Lime is a color that is a shade of green, so named because it is a representation of the color of the citrus fruit called limes. It is the color that is in between the web color chartreuse and yellow on the color wheel. Previous names for this color included, yellow green, lemon lime, lime green, or bitter lime.";
}


function myFunction8() {
    document.getElementById("demo").innerHTML = "Maroon is a dark reddish purple or dark brownish red color that takes its name from the French word marron, or chestnut. The Oxford English Dictionary describes it as 'a brownish crimson or claret color'. In the RGB model used to create colors on computer screens and televisions, maroon is created by turning down the brightness of pure red to about one half. Maroon is the complement of teal. ";
}

function myFunction9() {
    document.getElementById("demo").innerHTML = "Navy blue got its name from the dark blue (contrasted with white) worn by officers in the British Royal Navy since 1748 and subsequently adopted by other navies around the world. When this color name, taken from the usual color of the uniforms of sailors, originally came into use in the early 19th century, it was initially called marine blue, but the name of the color soon changed to navy blue";
}


function myFunction10() {
    document.getElementById("demo").innerHTML = "Olive is a dark yellowish-green color, like that of unripe or green olives. As a color word in the English language, it appears in late Middle English. Shaded toward gray, it becomes olive drab.";
}


function myFunction11() {
    document.getElementById("demo").innerHTML = "Purple is a color intermediate between blue and red. It is similar to violet, but unlike violet, which is a spectral color with its own wavelength on the visible spectrum of light, purple is a secondary color made by combining red and blue. The complementary color of purple in the RYB color model is yellow.";
}


function myFunction12() {
    document.getElementById("demo").innerHTML = "Red is the color at the end of the visible spectrum of light, next to orange and opposite violet. It has a dominant wavelength of approximately 625–740 nanometres. It is a primary color in the RGB color model and the CMYK color model, and is the complementary color of cyan. Reds range from the brilliant yellow-tinged scarlet and vermillion to bluish-red crimson, and vary in shade from the pale red pink to the dark red burgundy.";
}


function myFunction13() {
    document.getElementById("demo").innerHTML = "Silver or metallic gray is a color tone resembling gray that is a representation of the color of polished silver. Silver ingotThe visual sensation usually associated with the metal silver is its metallic shine. This cannot be reproduced by a simple solid color, because the shiny effect is due to the material's brightness varying with the surface angle to the light source.";
}


function myFunction14() {
    document.getElementById("demo").innerHTML = "Teal is a medium blue-green color, similar to cyan. Its name comes from that of a bird—the common teal (Anas crecca)—which presents a similarly colored stripe on its head. The word is often used colloquially to refer to shades of cyan in general. It can be created by mixing blue into a green base, or deepened as needed with black or gray. The complementary color of teal is maroon. It is also one of the initial group of 16 HTML/CSS web colors formulated in 1987.";
}


function myFunction15() {
    document.getElementById("demo").innerHTML = "White is the lightest color and is achromatic. It is the color of fresh snow, chalk, and milk, and is the opposite of black. White objects fully reflect and scatter all the visible wavelengths of light. White on television and computer screens is created by a mixture of red, blue and green light.";
}

function myFunction16() {
    document.getElementById("demo").innerHTML = "Yellow is the color between orange and green on the spectrum of visible light. It is evoked by light with a dominant wavelength of roughly 570–590 nm. It is a primary color in subtractive color systems, used in painting or color printing. In the RGB color model, used to create colors on television and computer screens, yellow is a secondary color made by combining red and green at equal intensity.";
}

document.getElementById("ciao").onclick = function(r, g, b) {

    r /= 255, g /= 255, b /= 255;

    var max = Math.max(r, g, b), min = Math.min(r, g, b);
    var h, s, l = (max + min) / 2;

    if (max == min) {
        h = s = 0;

    } else {
        var d = max - min;
        s = l > 0.5 ? d / (2 - max - min) : d / (max + min);
        switch (max) {
            case r: h = (g - b) / d + (g < b ? 6 : 0); break;
            case g: h = (b - r) / d + 2; break;
            case b: h = (r - g) / d + 4; break;
        }

        h /= 6;
    }


    return [h, s, l];
}



/* FUNZIONE RGB -> HSL */

function RGBTOHSL(r, g, b) {


    r /= 255, g /= 255, b /= 255;

    var max = Math.max(r, g, b), min = Math.min(r, g, b);
    var h, s, l = (max + min) / 2;

    if (max == min) {
        h = s = 0;

    } else {
        var d = max - min;
        s = l > 0.5 ? d / (2 - max - min) : d / (max + min);
        switch (max) {
            case r: h = (g - b) / d + (g < b ? 6 : 0); break;
            case g: h = (b - r) / d + 2; break;
            case b: h = (r - g) / d + 4; break;
        }

        h /= 6;
    }


    return [h, s, l];
}

/* FUNZIONE HSL -> RGB */

function HSLTORGB(h, s, l) {
    var r, g, b;

    if (s == 0) {

        r = g = b = l;

    } else {

        function hue2rgb(p, q, t) {

            if (t < 0) t += 1;
            if (t > 1) t -= 1;
            if (t < 1 / 6) return p + (q - p) * 6 * t;
            if (t < 1 / 2) return q;
            if (t < 2 / 3) return p + (q - p) * (2 / 3 - t) * 6;

            return p;
        }

        var q = l < 0.5 ? l * (1 + s) : l + s - l * s;
        var p = 2 * l - q;

        r = hue2rgb(p, q, h + 1 / 3);
        g = hue2rgb(p, q, h);
        b = hue2rgb(p, q, h - 1 / 3);
    }

    return [r * 255, g * 255, b * 255];
}

/* RGB TO HEX# */

function rgb2hex(red, green, blue) {
        var rgb = blue | (green << 8) | (red << 16);
        return '#' + (0x1000000 + rgb).toString(16).slice(1)


        
  }

  /* HEX TO RGB */
  function Hex2Rgb(hex) {
    var bigint = parseInt(hex, 16);
    var r = (bigint >> 16) & 255;
    var g = (bigint >> 8) & 255;
    var b = bigint & 255;

    return r + "," + g + "," + b;
}

