<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'store.label', default: 'Store')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <z:window style="padding:5px" apply="org.zkoss.bind.BindComposer"
            viewModel="@id('vm') @init('org.wherecaniget.StoreListVM')">
            <z:hlayout>
                <z:toolbarbutton href="${createLink(action:'create')}" image="/images/skin/database_add.png" label="${message(code:'default.new.label',args:[entityName])}"/>
                <z:space/>
                <z:label value='Store Name' />
                <z:textbox value="@bind(vm.filter)" instant='true' />
                <z:space/>
                <z:button  label="Search" onClick="@command('search')" disabled="@load(empty vm.filter)" />
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
            <z:listbox 
               emptyMessage="No Records"
               hflex='true'
               model="@bind(vm.stores) @save(vm.stores, before='search')">
               <z:listhead>
                  <z:listheader label="Id" />
                  <z:listheader label="Name" />
               </z:listhead>
               <z:template name='model' var='store'>
                  <listitem>
                     <listcell label="@load(store.id)" />
                     <listcell label="@load(store.name)" />
                  </listitem>
               </z:template>
            </z:listbox>
        </z:window>
    </body>
</html>
