package kz.gamma.certex.cms.web.services.common;

import kz.gamma.jce.provider.GammaTechProvider;
import kz.gamma.tumarcsp.profile.ProfileCreator;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.KeyStore;
import java.security.Security;

/**
 * Created by dansharky on 3/31/17.
 */
public abstract class KeyStoreProvider {

    private KeyStore store;
    private String password;

    public KeyStoreProvider(String profileName, String password) throws Exception {

        Security.addProvider(new GammaTechProvider());

        this.password = password;
        store = KeyStore.getInstance("GKS", "GAMMA");
        char[] passwd = password.toCharArray();

/*        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());*/
/*        File file = new File(fileName);

        String fileKeyName = file.getName();
        fileKeyName = fileKeyName.substring(0, fileKeyName.length() - 4);*/
/*        if (file.exists()) {

        }*/
        store.load(new ByteArrayInputStream(profileName.getBytes()), passwd);
    }

    public KeyStore getStore() {
        return store;
    }

    public void setStore(KeyStore store) {
        this.store = store;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
