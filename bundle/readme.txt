Утилита предназначена для тестирования веб-сервисов Certex.cms
 
Пример запуска:
java -jar wstester.jar -method getCityList -input /home/user/docIn.xml -wsdl http://localhost:8080/webra/Service?wsdl -xsd /home/user/pki_messages.xsd -profile officer_gost -pass 1

-method 
метод веб-сервиса который надо вызвать 
один из 
		createPerson, getCertList, revokeCert, requestCert,
        changePassword, findPerson, getCityList, getBankList, getCountryList,
        loadPerson, getIssuerList, removePerson, getRoleList, createOrder,
        getPositionList, getRegionList, getPersonList, getTariffList,
        updatePerson, getTumar, setDN, getOrganization, updateCUser,
        generateSnList, confirmOrder, getOrderList, getRequestList,
        getDelayedRequestList

-input
входной файл - пример приложен

-wsdl
адрес wsdl сервиса (необходимо соблюдать формат!) не забыть в конце ?wsdl

-xsd
xsd файл для валидации сообщений (в нашем случае тут два файла: сами сообщения и типы)
файл pki_type.xsd должен находиться в той же директории что и pki_messages.xsd
Оба файла приложены

-profile
название профайла, ключом которым будет подписан запрос


-pass
пароль к ключу

Пример аргументов:

-method createPerson -input /home/dansharky/docIn.xml -wsdl http://localhost:8080/webra/Service?wsdl -xsd /home/dansharky/pki_document.xsd -profile officer_gost -pass 1
