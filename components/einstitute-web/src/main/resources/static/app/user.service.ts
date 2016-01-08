import {User} from './user.model';

export class UserAuthenticationService {
	authenticate(user: User): boolean {
		if(user.userId == "lnj") {
			return true;
		}
		return false;
	}
}