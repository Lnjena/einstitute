import {Component} from 'angular2/core';
import {BaseComponent} from 'app/common/base.component';
import {Wallet} from './wallet.model';
import {WalletService} from './wallet.service';


@Component({
	selector: 'wallet-comp',
	templateUrl: 'app/user/wallet/wallet.view.html',
	providers: [WalletService]
})
export class WalletComponent extends BaseComponent {
	wallet: Wallet;
	walletService: WalletService;

	constructor(walletService: WalletService) {
		this.walletService = walletService;
	}
}