package paytm.labs.interview.challenge.external.spring.security.classes;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.springframework.stereotype.Component;

import paytm.labs.interview.challenge.external.spring.security.interfaces.AsymmetricKeysStoreServiceI;

@Component
public class RsaKeysStoreServiceC implements AsymmetricKeysStoreServiceI{
	
	final static String PRIVATE_FILE_EXTENSION = ".rsa.private";
	final static String PUBLIC_FILE_EXTENSION = ".rsa.public";
	final static String STORE_DIR_PATH = "keys//";
	protected java.util.Base64.Encoder m_base4encoder = java.util.Base64.getEncoder();
	protected java.util.Base64.Decoder m_base4decoder = java.util.Base64.getDecoder();
	
	public PublicKey getPublicKey (String strPath) throws Exception{
		return readPublic(strPath);
	}
	public PrivateKey getPrivateKey (String strPath) throws Exception{
		return readPrivateKey(strPath);
	}
	public void addPublicKey (String strPath, PublicKey publicKey) throws Exception{
		writePublicKey(strPath, publicKey);
	}
	public void addPrivateKey (String strPath, PrivateKey privateKey) throws Exception{
		writePrivateKey(strPath, privateKey);
	}
	//////////////////////
	
	public void writeKeyPair (String strPath, KeyPair keyPair) throws Exception{
		writePrivateKey(strPath, keyPair.getPrivate());
		writePublicKey(strPath, keyPair.getPublic());
	}

	private void writePublicKey(String strPath, PublicKey publicKey)  throws Exception{
		//byte[] arrbPublic = publicKey.getEncoded();
		String text = m_base4encoder.encodeToString(publicKey.getEncoded());
		//String strFormat = publicKey.getFormat();
		strPath = STORE_DIR_PATH + strPath + PUBLIC_FILE_EXTENSION;
		writeStringToFile (strPath, text);
	}
	
	private void writePrivateKey(String strPath, PrivateKey privateKey) throws Exception {
		//String strFormat = privateKey.getFormat();
		String text = m_base4encoder.encodeToString(privateKey.getEncoded());
		strPath = STORE_DIR_PATH + strPath + PRIVATE_FILE_EXTENSION;
		writeStringToFile (strPath, text);
	}
	
	protected void writeStringToFile(String strPath, String text) throws Exception {
		FileOutputStream  out = new FileOutputStream(strPath);
		PrintStream print = new PrintStream(out);
		print.print(text);
		out.close();
	}

	protected void writeBytesToFile(String strPath, byte[] data) throws Exception {
		FileOutputStream  out = new FileOutputStream(strPath);
		out.write(data);
		out.close();
	}

	public KeyPair readKeyPair (String strPath) throws Exception{
		PrivateKey privateKey =  readPrivateKey(strPath);
		PublicKey publicKey =  readPublic(strPath);
		KeyPair result = new KeyPair(publicKey, privateKey);
		return result;
	}

	protected PublicKey readPublic(String strPath) throws Exception{
		byte[] bytes = readBytesFromFile(STORE_DIR_PATH+strPath+PUBLIC_FILE_EXTENSION);
		bytes = m_base4decoder.decode(bytes);
		X509EncodedKeySpec ks = new X509EncodedKeySpec(bytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PublicKey publicKey = kf.generatePublic(ks);
		return publicKey;
	}

	protected PrivateKey readPrivateKey(String strPath) throws Exception {
		byte[] bytes = readBytesFromFile(STORE_DIR_PATH+ strPath+PRIVATE_FILE_EXTENSION);
		bytes = m_base4decoder.decode(bytes);
		PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(bytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = kf.generatePrivate(ks);
		return privateKey;
	}
	
	protected byte[] readBytesFromFile(String strPath) throws Exception {
		Path path = Paths.get(strPath);
		byte[] data = Files.readAllBytes(path);
		return data;
	}
}
