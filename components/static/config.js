 System.config({
    transpiler: 'typescript', 
    typescriptOptions: { emitDecoratorMetadata: true }, 
    packages: {'app': {defaultExtension: 'ts'}} 
  });
  System.import('app/boot').then(null, console.error.bind(console));

//http-proxy = "http://502400119:Pa66word@CIS-Lond-pitc-SSOW.proxy.corporate.ge.com:80"
//https-proxy = "http://502400119:Pa66word@cis-lond-pitc-ssow.proxy.corporate.ge.com:80/"
//proxy = "http://502400119:Pa66word@cis-lond-pitc-ssow.proxy.corporate.ge.com:80/"