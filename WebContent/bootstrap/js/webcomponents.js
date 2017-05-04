(function(){
/*
 Copyright (c) 2016 The Polymer Project Authors. All rights reserved.
 This code may only be used under the BSD style license found at http://polymer.github.io/LICENSE.txt
 The complete set of authors may be found at http://polymer.github.io/AUTHORS.txt
 The complete set of contributors may be found at http://polymer.github.io/CONTRIBUTORS.txt
 Code distributed by Google as part of the polymer project is also
 subject to an additional IP rights grant found at http://polymer.github.io/PATENTS.txt
 Copyright (c) 2014 The Polymer Project Authors. All rights reserved.
 This code may only be used under the BSD style license found at http://polymer.github.io/LICENSE.txt
 The complete set of authors may be found at http://polymer.github.io/AUTHORS.txt
 The complete set of contributors may be found at http://polymer.github.io/CONTRIBUTORS.txt
 Code distributed by Google as part of the polymer project is also
 subject to an additional IP rights grant found at http://polymer.github.io/PATENTS.txt
Copyright (c) 2017 The Polymer Project Authors. All rights reserved.
This code may only be used under the BSD style license found at http://polymer.github.io/LICENSE.txt
The complete set of authors may be found at http://polymer.github.io/AUTHORS.txt
The complete set of contributors may be found at http://polymer.github.io/CONTRIBUTORS.txt
Code distributed by Google as part of the polymer project is also
subject to an additional IP rights grant found at http://polymer.github.io/PATENTS.txt
*/
'use strict';(function(m){function n(a,b){if("function"===typeof window.CustomEvent)return new CustomEvent(a,b);var c=document.createEvent("CustomEvent");c.initCustomEvent(a,!!b.bubbles,!!b.cancelable,b.detail);return c}function k(a){if(t)return a.ownerDocument!==document?a.ownerDocument:null;var b=a.__importDoc;if(!b&&a.parentNode){b=a.parentNode;if("function"===typeof b.closest)b=b.closest("link[rel=import]");else for(;!u(b)&&(b=b.parentNode););a.__importDoc=b}return b}function v(a){var b=document.querySelectorAll("link[rel=import]:not(import-dependency)"),
c=b.length;if(c)for(var e=0,d=b.length,h;e<d&&(h=b[e]);e++)w(h,function(){--c||a()});else a()}function q(a){if("loading"!==document.readyState)a();else{var b=function(){"loading"!==document.readyState&&(document.removeEventListener("readystatechange",b),a())};document.addEventListener("readystatechange",b)}}function p(a){q(function(){return v(function(){return a&&a()})})}function w(a,b){if(a.__loaded)b&&b();else if(u(a)&&!t&&null===a.import||a.import&&"complete"===a.import.readyState)a.__loaded=!0,
b&&b();else if("script"!==a.localName||a.src){var c=function(e){a.removeEventListener(e.type,c);a.__loaded=!0;b&&b()};a.addEventListener("load",c);z&&"style"===a.localName||a.addEventListener("error",c)}else a.__loaded=!0,b&&b()}function u(a){return a.nodeType===Node.ELEMENT_NODE&&"link"===a.localName&&"import"===a.rel}function l(){var a=this;this.b={};this.c=0;this.g=new MutationObserver(function(b){return a.C(b)});q(function(){a.g.observe(document.head,{childList:!0,subtree:!0});a.h(document)})}
var t="import"in document.createElement("link"),A=null;!1==="currentScript"in document&&Object.defineProperty(document,"currentScript",{get:function(){return A||("complete"!==document.readyState?document.scripts[document.scripts.length-1]:null)},configurable:!0});var F=/(^\/)|(^#)|(^[\w-\d]*:)/,G=/(url\()([^)]*)(\))/g,H=/(@import[\s]+(?!url\())([^;]*)(;)/g,I=/(<link[^>]*)(rel=['|"]?stylesheet['|"]?[^>]*>)/g,f={A:function(a,b){a.href&&a.setAttribute("href",f.i(a.getAttribute("href"),b));a.src&&a.setAttribute("src",
f.i(a.getAttribute("src"),b));if("style"===a.localName){var c=f.u(a.textContent,b,G);a.textContent=f.u(c,b,H)}},u:function(a,b,c){return a.replace(c,function(a,c,h,g){a=h.replace(/["']/g,"");b&&(a=f.v(a,b));return c+"'"+a+"'"+g})},i:function(a,b){return a&&F.test(a)?a:f.v(a,b)},v:function(a,b){if(void 0===f.f){f.f=!1;try{var c=new URL("b","http://a");c.pathname="c%20d";f.f="http://a/c%20d"===c.href}catch(e){}}if(f.f)return(new URL(a,b)).href;c=f.w;c||(c=document.implementation.createHTMLDocument("temp"),
f.w=c,c.l=c.createElement("base"),c.head.appendChild(c.l),c.j=c.createElement("a"));c.l.href=b;c.j.href=a;return c.j.href||a}},C={async:!0,load:function(a,b,c){if(a)if(a.match(/^data:/)){a=a.split(",");var e=a[1],e=-1<a[0].indexOf(";base64")?atob(e):decodeURIComponent(e);b(e)}else{var d=new XMLHttpRequest;d.open("GET",a,C.async);d.onload=function(){var a=d.getResponseHeader("Location");a&&!a.indexOf("/")&&(a=(location.origin||location.protocol+"//"+location.host)+a);var e=d.response||d.responseText;
304===d.status||!d.status||200<=d.status&&300>d.status?b(e,a):c(e)};d.send()}else c("error: href must be specified")}},z=/Trident/.test(navigator.userAgent)||/Edge\/\d./i.test(navigator.userAgent);l.prototype.h=function(a){a=a.querySelectorAll("link[rel=import]");for(var b=0,c=a.length;b<c;b++)this.o(a[b])};l.prototype.o=function(a){var b=this,c=a.href;if(void 0!==this.b[c]){var e=this.b[c];e&&e.__loaded&&(a.import=e,this.m(a))}else this.c++,this.b[c]="pending",C.load(c,function(a,e){a=b.D(a,e||c);
b.b[c]=a;b.c--;b.h(a);b.s()},function(){b.b[c]=null;b.c--;b.s()})};l.prototype.D=function(a,b){if(!a)return document.createDocumentFragment();z&&(a=a.replace(I,function(a,b,c){return-1===a.indexOf("type=")?b+" type=import-disable "+c:a}));var c=document.createElement("template");c.innerHTML=a;if(c.content)a=c.content;else for(a=document.createDocumentFragment();c.firstChild;)a.appendChild(c.firstChild);if(c=a.querySelector("base"))b=f.i(c.getAttribute("href"),b),c.removeAttribute("href");for(var c=
a.querySelectorAll('link[rel=import], link[rel=stylesheet][href][type=import-disable],\n    style:not([type]), link[rel=stylesheet][href]:not([type]),\n    script:not([type]), script[type="application/javascript"],\n    script[type="text/javascript"]'),e=0,d=0,h=c.length,g;d<h&&(g=c[d]);d++)w(g),f.A(g,b),g.setAttribute("import-dependency",""),"script"===g.localName&&!g.src&&g.textContent&&(g.setAttribute("src","data:text/javascript;charset=utf-8,"+encodeURIComponent(g.textContent+("\n//# sourceURL="+
b+(e?"-"+e:"")+".js\n"))),g.textContent="",e++);return a};l.prototype.s=function(){var a=this;if(!this.c){this.g.disconnect();this.flatten(document);var b=!1,c=!1,e=function(){c&&b&&(a.g.observe(document.head,{childList:!0,subtree:!0}),a.B())};this.G(function(){c=!0;e()});this.F(function(){b=!0;e()})}};l.prototype.flatten=function(a){a=a.querySelectorAll("link[rel=import]");for(var b={},c=0,e=a.length;c<e&&(b.n=a[c]);b={n:b.n},c++){var d=this.b[b.n.href];(b.n.import=d)&&d.nodeType===Node.DOCUMENT_FRAGMENT_NODE&&
(this.b[b.n.href]=b.n,b.n.readyState="loading",b.n.import=b.n,Object.defineProperty(b.n,"baseURI",{get:function(a){return function(){return a.n.href}}(b),configurable:!0,enumerable:!0}),this.flatten(d),b.n.appendChild(d))}};l.prototype.F=function(a){function b(d){if(d<e){var h=c[d],g=document.createElement("script");h.removeAttribute("import-dependency");for(var x=0,f=h.attributes.length;x<f;x++)g.setAttribute(h.attributes[x].name,h.attributes[x].value);A=g;h.parentNode.replaceChild(g,h);w(g,function(){A=
null;b(d+1)})}else a()}var c=document.querySelectorAll("script[import-dependency]"),e=c.length;b(0)};l.prototype.G=function(a){var b=document.querySelectorAll("style[import-dependency],\n    link[rel=stylesheet][import-dependency]"),c=b.length;if(c)for(var e=z&&!!document.querySelector("link[rel=stylesheet][href][type=import-disable]"),d={},h=0,g=b.length;h<g&&(d.a=b[h]);d={a:d.a},h++){if(w(d.a,function(b){return function(){b.a.removeAttribute("import-dependency");--c||a()}}(d)),e&&d.a.parentNode!==
document.head){var f=document.createElement(d.a.localName);f.__appliedElement=d.a;f.setAttribute("type","import-placeholder");d.a.parentNode.insertBefore(f,d.a.nextSibling);for(f=k(d.a);f&&k(f);)f=k(f);f.parentNode!==document.head&&(f=null);document.head.insertBefore(d.a,f);d.a.removeAttribute("type")}}else a()};l.prototype.B=function(){for(var a=document.querySelectorAll("link[rel=import]"),b=a.length-1,c;0<=b&&(c=a[b]);b--)this.m(c)};l.prototype.m=function(a){a.__loaded||(a.__loaded=!0,a.import&&
(a.import.readyState="complete"),a.dispatchEvent(n(a.import?"load":"error",{bubbles:!1,cancelable:!1,detail:void 0})))};l.prototype.C=function(a){for(var b=0;b<a.length;b++){var c=a[b];if(c.addedNodes)for(var e=0;e<c.addedNodes.length;e++){var d=c.addedNodes[e];d&&d.nodeType===Node.ELEMENT_NODE&&(u(d)?this.o(d):this.h(d))}}};if(t){for(var r=document.querySelectorAll("link[rel=import]"),B=0,J=r.length,y;B<J&&(y=r[B]);B++)y.import&&"loading"===y.import.readyState||(y.__loaded=!0);r=function(a){a=a.target;
u(a)&&(a.__loaded=!0)};document.addEventListener("load",r,!0);document.addEventListener("error",r,!0)}else new l;p(function(){return document.dispatchEvent(n("HTMLImportsLoaded",{cancelable:!0,bubbles:!0,detail:void 0}))});m.useNative=t;m.whenReady=p;m.importForElement=k})(window.HTMLImports=window.HTMLImports||{});
(function(){var m=window.customElements,n=window.HTMLImports;if(m&&m.polyfillWrapFlushCallback){var k,v=function(){if(k){var p=k;k=null;p();return!0}},q=n.whenReady;m.polyfillWrapFlushCallback(function(p){k=p;q(v)});n.whenReady=function(k){q(function(){v()?n.whenReady(k):k()})}}n.whenReady(function(){requestAnimationFrame(function(){window.dispatchEvent(new CustomEvent("WebComponentsReady"))})})})();var D=document.createElement("style");D.textContent="body {transition: opacity ease-in 0.2s; } \nbody[unresolved] {opacity: 0; display: block; overflow: hidden; position: relative; } \n";
var E=document.querySelector("head");E.insertBefore(D,E.firstChild);
}).call(self)

//# sourceMappingURL=webcomponents-hi.js.map