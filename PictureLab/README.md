# PictureLab
This project is designed to help you learn how to use 2D arrays. In addition, you will learn a lot about [`Color`](https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html) class. The only files you need to edit are the [`PictureTester`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java) class and the [`Picture`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/Picture.java) class.

---

The [`PictureTester`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java) tasks are to complete the following methods:

| [`testKeepOnlyBlue();`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java#L111) |
| :-- |
| Keeps only the blue part of each color, setting the other two to zero. |

| [`testKeepOnlyRed();`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java#L151) |
| :-- |
| Keeps only the red part of each color, setting the other two to zero. |

| [`testKeepOnlyGreen();`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java#L131) |
| :-- |
| Keeps only the green part of each color, setting the other two to zero. |

| [`testNegate();`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java#L173) |
| :-- |
| Runs the [`negate()`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/Picture.java#L87) method of [`Picture`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/Picture.java) class, which basically "flips" each pixel's color by replacing each color attribute with its complement. |

| [`testGrayscale();`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java#L185) |
| :-- |
| Creates a grayscale of the image using the [`grayScale()`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/Picture.java#L103) method of the [`Picture`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/Picture.java) class. |

| [`testEdgeDetection();`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java#L194) |
| :-- |
| Detects abrupt changes in the color of [`images/swan.jpg`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/images/swan.jpg) using the [`edgeDetection()`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/Picture.java#L182) method of the [`Picture`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/Picture.java) class. The result of this edge detection is then written to [`images/swanOutline.jpg`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/images/swanOutline.jpg) |

| [`testFixUnderwater();`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java#L472) |
| :-- |
| Creates a rough approximation of how [`images/water.jpg`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/images/water.jpg) would look had it not been under water and displays this modified image in a new window. It works by arbitrarily reducing the blue and green components of each pixel and slightly increasing their red components. |

| [`testChromakey();`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java#L425) |
| :-- |
| Green screen technology. This superimposes one pic ([`images/spidey.jpg`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/images/spidey.jpg)) onto another ([`images/butterfly1.jpg`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/images/butterfly1.jpg)) ignoring the pixels that are close (distance-wise) to green. |

| [`testEncodeAndDecode();`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java#L349) |
| :-- |
| Very cool. This takes an image that is to hold the secret message. That image is altered slightly with the (all of the pixels' red components are made to be even). Then the message is superimposed onto the image adding one to every corresponding pixels' red component. Then the image can be sent to someone else and they can look for all the pixels that have an odd red component. |

| [`testGetCountRedOverValue(int i);`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java#L319) |
| :-- |
| Gets the number of pixels which have a red component above a parameter `i`. |

| [`testSetRedToHalfValueInTopHalf();`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java#L300) |
| :-- |
| Cuts all the color components red values to half of what they were, in the top half of the image. |

| [`testClearBlueOverValue(int i);`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java#L280) |
| :-- |
| Sets the blue component of a pixel to zero if it is above a parameter `i`. |

| [`testGetAverageForColumn(pic, col);`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java#L256) |
| :-- |
| This method calculates the average color of the specified pic and the given column. |

---

The [`Picture`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/Picture.java) tasks are to complete the following methods:

| [`negate();`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/Picture.java#L87) |
| :-- |
| Creates a negative of the picture. This basically "flips" the color by replacing each pixel's color attribute with its complement. This method is used in the [`testNegate()`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java#L173) method of the [`PictureTester`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java) class. |

| [`grayScale();`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/Picture.java#L103) |
| :-- |
| Makes the image grayscale by setting each pixel's individual RGB components to equal their initial average. This method is used in the [`testGrayscale()`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java#L185) method of the [`PictureTester`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/PictureTester.java) class. |

| [`edgeDetection(int edgeDist);`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/Picture.java#L182) |
| :-- |
| Goes through each pixel in the image, comparing it to its righthand neighbor if it exists (it will not check for the rightmost pixel). If it's color distance (found using the [`colorDistance()`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/Pixel.java#L330) method of the [`Pixel`](https://github.com/Angad-The-Coder/APCS-Code/tree/master/PictureLab/src/Pixel.java) class) from its righthand neigbor is greater than the `edgeDist` parameter, the pixel's color is set to black ([`Color.BLACK`](https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html#BLACK)); otherwise, it is set to white ([`Color.WHITE`](https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html#WHITE)). |