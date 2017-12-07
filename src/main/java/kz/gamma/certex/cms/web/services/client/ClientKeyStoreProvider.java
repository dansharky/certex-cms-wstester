package kz.gamma.certex.cms.web.services.client;


import kz.gamma.certex.cms.web.services.common.KeyStoreProvider;

/**
 * Created by dansharky on 4/13/17.
 */
public class ClientKeyStoreProvider extends KeyStoreProvider {

    public ClientKeyStoreProvider(String fileName, String password) throws Exception {
        super(fileName, password);
    }
}

