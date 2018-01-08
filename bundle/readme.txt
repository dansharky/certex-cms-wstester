Утилита предназначена для тестирования веб-сервисов Certex.cms
 
Пример запуска:
java -jar wstester.jar -method createPerson -input /home/dansharky/docIn.xml -output result.xml -wsdl http://localhost:8080/webra/Service?wsdl -profile officer_gost -pass 1

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

-output
название под которым будет сохранен файл ответа

-wsdl
адрес wsdl сервиса (необходимо соблюдать формат!) не забыть в конце ?wsdl

-profile
название профайла, ключом которым будет подписан запрос

-pass
пароль к ключу

Пример аргументов:

-method createPerson -input /home/dansharky/docIn.xml -output result.xml -wsdl http://localhost:8080/webra/Service?wsdl -profile officer_gost -pass 1

директория, из которой запускается jar должна содержать xsd файлы pki_document.xsd и pki_type.xsd
(название файлов должно быть таким же!)