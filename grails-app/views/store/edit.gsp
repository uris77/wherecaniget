<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'store.label', default: 'Store')}" />
    <title><g:message code="default.edit.label" args="[entityName]" /></title>
</head>

<body>
<z:window style="padding:5px" apply="org.wherecaniget.store.EditComposer">
    <z:longbox name="id" value="${storeInstance.id}" visible="false"/>
    <z:longbox name="version" value="${storeInstance.version}" visible="false"/>
    <g:if test="${flash.message}">
        <z:window mode="popup" border="normal" style="margin-bottom:5px">
            <z:hlayout>
                <z:image src="/images/skin/information.png"/>
                <z:div>
                    ${flash.message}
                </z:div>
            </z:hlayout>
        </z:window>
    </g:if>
    <z:grid>
        <z:columns sizable="true">
            <z:column label="${message(code:'name',default:'Name')}" width="100px"/>
            <z:column label="${message(code:'value',default:'Value')}"/>
        </z:columns>
        <z:rows>
        
            <z:row>
                <z:label value="${message(code:'store.name.label',default:'Name')}"/>
                <z:textbox name="name" value="${storeInstance?.name}" />
            </z:row>
        
        </z:rows>
    </z:grid>
    <z:hlayout>
        <z:button id="saveButton" label="${message(code: 'default.button.update.label', default: 'Update')}"/>
        <z:button href="${createLink(action:'list')}" label="${message(code: 'default.list.label', args:[entityName])}"/>
    </z:hlayout>
</z:window>
</body>
</html>