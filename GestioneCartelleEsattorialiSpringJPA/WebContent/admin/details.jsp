<c:forEach items="${utenteDTOAttribute.fieldsNames()}" var="field">
	<dl class="row">
		<dt class="col-sm-3 text-right">${field.key }</dt>
		<dd class="col-sm-9">
			${utenteDTOAttribute.fieldsValues[field.key]}</dd>
	</dl>
</c:forEach>

<dl class="row">
	<dt class="col-sm-3 text-right">Ruolo</dt>
	<dd class="col-sm-9">
		<c:forEach items="${ruoliUtenteDTOAttribute}" var="ruolo"
			varStatus="loop">
				${ruolo.descrizione} 
				<c:if test="${ruoliUtenteDTOAttribute.size()-1 > loop.index}">, </c:if>
		</c:forEach>
	</dd>
</dl>