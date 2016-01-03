package br.com.triadworks.bugtracker.controller.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator
public class SenhaForteValidator implements Validator{

	@Override
	public void validate(FacesContext ctx, UIComponent cmp, Object obj)
	
			throws ValidatorException {
				String senha = obj.toString();
				if(!senha.contains("@")){
					throw new ValidatorException(
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha Fraca! ", "Me ajude, digite uma senha razoável."));
				}
				
			}
	

}
