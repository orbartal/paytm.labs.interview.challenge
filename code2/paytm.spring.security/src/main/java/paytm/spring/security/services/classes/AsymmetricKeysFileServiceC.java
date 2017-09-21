package paytm.spring.security.services.classes;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.stereotype.Component;
import paytm.spring.security.services.interfaces.AsymmetricKeysIdToPathMapperI;
import paytm.spring.security.services.interfaces.AsymmetricKeysIOServiceI;

@Component
public class AsymmetricKeysFileServiceC implements AsymmetricKeysIOServiceI {

	protected AsymmetricKeysIdToPathMapperI m_idToPathMapper;
	public AsymmetricKeysFileServiceC (AsymmetricKeysIdToPathMapperI idToPathMapper) {
		m_idToPathMapper = idToPathMapper;
	}
	
	@Override
	public String readPublicKey(String strId) throws Exception {
		String strPath = m_idToPathMapper.getPublicPath(strId);
		return readTextFromFile (strPath);
	}

	@Override
	public String readPrivateKey(String strId) throws Exception {
		String strPath = m_idToPathMapper.getPrivatePath(strId);
		return readTextFromFile (strPath);
	}

	@Override
	public void writePublicKey(String strId, String strPublicKey) throws Exception {
		String strPath = m_idToPathMapper.getPublicPath(strId);
		writeTextToFile(strPath, strPublicKey);
	}

	@Override
	public void writePrivateKey(String strId, String strPrivateKey) throws Exception {
		String strPath = m_idToPathMapper.getPrivatePath(strId);
		writeTextToFile(strPath, strPrivateKey);
	}
	
	///////////
	protected String readTextFromFile(String strPath) throws Exception {
		return new String(Files.readAllBytes(Paths.get(strPath)));
	}
	
	protected void writeTextToFile(String strPath, String text) throws Exception {
		Files.write(Paths.get(strPath), text.getBytes());
	}
}