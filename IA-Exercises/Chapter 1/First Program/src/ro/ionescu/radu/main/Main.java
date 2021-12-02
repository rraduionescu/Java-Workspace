package ro.ionescu.radu.main;

public class Main
{
	public static void main(String[] args)
	{
		byte  byteVariable;    // 1 byte  Val: [ -2ˆ7 ; 2ˆ7-1]->[           -128            ;            127           ]
		short shortVariable;   // 2 bytes Val: [-2ˆ15 ;2ˆ15-1]->[         -32.768           ;          32.767          ]
		int   integerVariable; // 4 bytes Val: [-2ˆ31 ;2ˆ31-1]->[      -2.147.483.648       ;       2.147.483.647      ]
		long  longVariable;    // 8 bytes Val: [-2ˆ63 ;2ˆ63-1]->[-9.223.372.036.854.775.808 ; 9.223.372.036.854.775.807]

		char characterVariable;  // 2 bytes Val: [ 0 ; 2ˆ16-1 ]->[ 0 ; 65.535 ]

		float  floatVariable;    // 4 bytes Val: [Rational number]
		double doubleVariable;   // 8 bytes Val: [Rational number]

		boolean booleanVariable; // [true or false]

		byteVariable = 127;      // = 128 error : incompatible types
		System.out.println("byteVariable = " + byteVariable);
		byteVariable = -128;
		System.out.println("byteVariable = " + byteVariable);

		shortVariable = 32_767;  // = 32.768 error : incompatible types
		System.out.println("shortVariable = " + shortVariable);
		shortVariable = -32_768;
		System.out.println("shortVariable = " + shortVariable);

		integerVariable = 2_147_483_647; // = 2.147.483.647 error : integer too large
		System.out.println("integerVariable = " + integerVariable);
		integerVariable = -2_147_483_648;
		System.out.println("integerVariable = " + integerVariable);

		longVariable = 9_223_372_036_854_775_807L; // = 9.223.372.036.854.775.808 error : long number too large
		System.out.println("longVariable = " + longVariable);
		longVariable = -9_223_372_036_854_775_808L;
		System.out.println("longVariable = " + longVariable);

		characterVariable = 65_535; // = 65.536 error : incompatible types
		System.out.println("characterVariable = " + characterVariable);
		characterVariable = 'A';
		System.out.println("characterVariable = " + characterVariable);
		characterVariable++;
		System.out.println("characterVariable = " + characterVariable);

		floatVariable = 52.34525F;
		System.out.println("floatVariable = " + floatVariable);
		floatVariable += 243.53927F;
		System.out.println("floatVariable = " + floatVariable);

		doubleVariable = 2345.1239344D;
		System.out.println("doubleVariable = " + doubleVariable);
		doubleVariable += 9283.3940298D;
		System.out.println("doubleVariable = " + doubleVariable);

		booleanVariable = true;
		System.out.println("booleanVariable = " + booleanVariable);
		booleanVariable = false;
		System.out.println("booleanVariable = " + booleanVariable);

		System.out.print("Characters : ");
		for(int i = 33 ; i <= 128 ; i++)
		{
			System.out.print((char)i + " ");
		}

		System.out.println();
		integerVariable = 0x4A;          // hexadecimal representation
		System.out.println("Hexadecimal 4A = " + integerVariable);
		longVariable = 0b0100_1010;   // binary representation
		System.out.println("Binary 0100_1010 = " + longVariable);
		characterVariable = '\u0045';    // unicode code
		System.out.println("Unicode 0045 = " + characterVariable);

		// Binary arithmetic operators
		integerVariable = 83;
		longVariable    = 45;
		System.out.println(longVariable + " + " + integerVariable + " = " + (longVariable + integerVariable));// addition
		System.out.println(longVariable + " - " + integerVariable + " = " + (longVariable - integerVariable));// subtraction
		System.out.println(longVariable + " * " + integerVariable + " = " + (longVariable * integerVariable));// multiplication
		System.out.println(integerVariable + " / " + longVariable + " = " + (integerVariable / longVariable));// integer division
		System.out.println(integerVariable + " % " + longVariable + " = " + (integerVariable % longVariable));// modulo
		System.out.println(doubleVariable + " / " + floatVariable + " = " + (doubleVariable / floatVariable));// rational division

		// Bitwise operators
		integerVariable = 0b0010_1010;
		longVariable    = 0b0100_0110;
					//AND 0b0000_0010 = 2
					//ORR 0b0110_1110 = 110
					//XOR 0b0110_1100 = 108
					//COM 0b1101_0101 = -43
					//LSF 0b0101_0100 = 84
					//RSF 0b0001_0101 = 21
					//RZS 0b0001_0101 = 21
		System.out.println("a AND b = " + (integerVariable & longVariable));
		System.out.println("a ORR b = " + (integerVariable | longVariable));
		System.out.println("a XOR b = " + (integerVariable ^ longVariable));
		System.out.println("COM   a = " + (~integerVariable));
		System.out.println("LSF   a = " + (integerVariable << 1));
		System.out.println("RSF   a = " + (integerVariable >> 1));
		System.out.println("RZS   a = " + (integerVariable >>> 1));

		// Ternary operator
		System.out.println("x > y ? " + (longVariable > integerVariable ? "is true" : "is false"));
	}
}
