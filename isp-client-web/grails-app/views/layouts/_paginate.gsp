<div class="text-right">
	<g:form action="list">
		<g:hiddenField name="text" value="${text}" />
		<fieldset class="buttons">
			<g:if test="${page > 0}">
				<button type="submit" class="btn btn-default" name="page"
					value="${page - 1}">
					<i class="fa fa-arrow-left"></i> Anterior
				</button>
			</g:if>
			<g:else>
				<button type="submit" class="btn btn-default" name="page"
					value="${page - 1}" disabled>
					<i class="fa fa-arrow-left"></i> Anterior
				</button>
			</g:else>
			<g:if test="${siguiente > 0}">
				<button type="submit" class="btn btn-default" name="page"
					value="${page + 1}">
					<i class="fa fa-arrow-right"></i> Siguiente
				</button>
			</g:if>
			<g:else>
				<button type="submit" class="btn btn-default" name="page"
					value="${page + 1}" disabled>
					<i class="fa fa-arrow-right"></i> Siguiente
				</button>
			</g:else>
		</fieldset>
	</g:form>
</div>