package login

import com.sd.isp.beans.role.RoleB

class Util {

  static translateRole(rolename) {
	def rol
	switch (rolename) {
	  case "ROLE_SUPERUSER": rol="Superusuario"; break;
	  case "ROLE_ADMIN": rol="Administrador"; break;
	  default: rol="Ninguno";
	}
	return rol
  }
}
