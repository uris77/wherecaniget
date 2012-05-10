<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'store.label', default: 'Store')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <z:window style="padding:5px" apply="org.wherecaniget.store.ListComposer">
            <z:hlayout>
                <z:toolbarbutton href="${createLink(action:'create')}" image="/images/skin/database_add.png" label="${message(code:'default.new.label',args:[entityName])}"/>
                <z:space/>
                <z:label value="${message(code:'store.id',default:'Id')}"/>
                <z:longbox id="idLongbox"/>
                <z:space/>
                <z:button id="searchButton" label="${message(code:'search')}"/>
            </z:hlayout>
            <g:if test="${flash.message}">
                <z:window mode="popup" border="normal">
                    <z:hlayout>
                        <z:image src="/images/skin/information.png"/>
                        <z:div>
                            ${flash.message}
                        </z:div>
                    </z:hlayout>
                </z:window>
            </g:if>
            <z:grid id="grid" emptyMessage="${message(code:'emptyMessage',default:'No Record')}">
                <z:columns sizable="true">
                    <z:column label="${message(code: 'store.id.label', default: 'Id')}"/>
                    <z:column label="${message(code: 'store.name.label', default: 'Name')}"/>
                    <z:column width="150px"/>
                </z:columns>
            </z:grid>
            <z:paging autohide="true" id="paging" pageSize="15"/>
        </z:window>
    </body>
</html>