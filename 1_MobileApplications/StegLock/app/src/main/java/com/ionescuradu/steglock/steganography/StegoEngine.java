package com.ionescuradu.steglock.steganography;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

//  Created by Ionescu Radu Stefan  //

public class StegoEngine
{
	private static SecretKeySpec secretKey;
	private static byte[]        key;

	public static void setKey(String myKey)
	{
		MessageDigest sha = null;
		try
		{
			key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@RequiresApi(api = Build.VERSION_CODES.O)
	public static String encrypt(String strToEncrypt, String secret)
	{
		try
		{
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		}
		catch (Exception e)
		{
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	@RequiresApi(api = Build.VERSION_CODES.O)
	public static String decrypt(String strToDecrypt, String secret)
	{
		try
		{
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		}
		catch (Exception e)
		{
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}

	public static byte[] embed(byte[] cipher, ImageView image)
	{
		int       cipherLength = cipher.length * 8;
		boolean[] bits         = new boolean[32 + cipherLength];
		String    binary       = Integer.toBinaryString(cipherLength);

		while (binary.length() < 32)
		{
			binary = 0 + binary;
		}
		for (int i = 0; i < 32; i++)
		{
			bits[i] = binary.charAt(i) == '1';
		}

		for (int i = 0; i < cipher.length; i++)
		{
			byte b = cipher[i];
			for (int j = 0; j < 8; j++)
			{
				bits[32 + i * 8 + j] = ((b >> (7 - j)) & 1) == 1;
			}
		}

		Bitmap         bitmap;
		BitmapDrawable bitmapDrawable = (BitmapDrawable) image.getDrawable();
		bitmap = bitmapDrawable.getBitmap();
		Bitmap operation = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
		int    count     = 0;

		for (int i = 0; i < bitmap.getWidth(); i++)
		{
			for (int j = 0; j < bitmap.getHeight(); j++)
			{
				int p = bitmap.getPixel(i, j);

				int r = Color.red(p);
				int g = Color.green(p);
				int b = Color.blue(p);
				int a = Color.alpha(p);

				if (count < 32 + cipherLength)
				{
					if (bits[count] && b % 2 == 0)
					{
						if (b > 1)
						{
							operation.setPixel(i, j, Color.argb(a, r, g, b - 1));
						}
						else
						{
							operation.setPixel(i, j, Color.argb(a, r, g, b + 1));
						}
						count++;
					}
					else if (!bits[count] && b % 2 == 1)
					{
						if (b > 1)
						{
							operation.setPixel(i, j, Color.argb(a, r, g, b - 1));
						}
						else
						{
							operation.setPixel(i, j, Color.argb(a, r, g, b + 1));
						}
						count++;
					}
					else if (bits[count] && b % 2 == 1)
					{
						operation.setPixel(i, j, Color.argb(a, r, g, b));
						count++;
					}
					else if (!bits[count] && b % 2 == 0)
					{
						operation.setPixel(i, j, Color.argb(a, r, g, b));
						count++;
					}
				}
				else
				{
					operation.setPixel(i, j, Color.argb(a, r, g, b));
				}
			}
		}

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		operation.compress(Bitmap.CompressFormat.PNG, 100, stream);

		return stream.toByteArray();
	}

	public static byte[] embedAudio(byte[] cipher, byte[] audio)
	{
		int       cipherLength = cipher.length * 8;
		boolean[] bits         = new boolean[32 + cipherLength];
		String    binary       = Integer.toBinaryString(cipherLength);

		while (binary.length() < 32)
		{
			binary = 0 + binary;
		}
		for (int i = 0; i < 32; i++)
		{
			bits[i] = binary.charAt(i) == '1';
		}

		for (int i = 0; i < cipher.length; i++)
		{
			byte b = cipher[i];
			for (int j = 0; j < 8; j++)
			{
				bits[32 + i * 8 + j] = ((b >> (7 - j)) & 1) == 1;
			}
		}

		byte[]     embedded = new byte[audio.length + 4 + cipher.length];
		ByteBuffer bytes    = ByteBuffer.allocate(4).putInt(cipher.length);
		byte[]     array    = bytes.array();
		for (int i = 0; i < 4; i++)
		{
			embedded[i] = array[i];
		}
		for (int i = 4; i < cipher.length + 4; i++)
		{
			embedded[i] = cipher[i];
		}
		for (int i = cipher.length + 4; i < audio.length + cipher.length + 4; i++)
		{
			embedded[i] = audio[i];
		}

		return embedded;
	}

	@RequiresApi(api = Build.VERSION_CODES.O)
	public static String extract(ImageView img, String uid)
	{
		Bitmap         bitmap;
		String         message        = "";
		BitmapDrawable bitmapDrawable = (BitmapDrawable) img.getDrawable();
		bitmap = bitmapDrawable.getBitmap();
		StringBuilder length = new StringBuilder();

		for (int i = 0; i < 1; i++)
		{
			for (int j = 0; j < 32; j++)
			{
				int p = bitmap.getPixel(i, j);
				if (p % 2 == 0)
				{
					length.append('0');
				}
				else
				{
					length.append('1');
				}
			}
		}

		int l = Integer.parseInt(length.toString(), 2);
		Log.e("extract len", l + "");
		int           count            = 0;
		StringBuilder cipherStringBits = new StringBuilder();

		for (int i = 0; i < bitmap.getWidth() && count < l; i++)
		{
			for (int j = 0; j < bitmap.getHeight(); j++)
			{
				if (i == 0 && j < 32)
				{
					continue;
				}
				else
				{
					if (count < l)
					{
						if (bitmap.getPixel(i, j) % 2 == 0)
						{
							cipherStringBits.append('0');
							count++;
						}
						else
						{
							cipherStringBits.append('1');
							count++;
						}
					}
					else
					{
						break;
					}
				}
			}
		}
		int charCode;
		for (int i = 0; i < l / 8; i++)
		{
			charCode = Integer.parseInt(cipherStringBits.toString().substring(i * 8, i * 8 + 8), 2);
			String str = Character.valueOf((char) charCode).toString();
			message = message + str;
		}

		return decrypt(message, uid);
	}
}