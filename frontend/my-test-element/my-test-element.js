import { html, LitElement } from 'lit';

class MyTestElement extends LitElement {

  static get properties() {
    return {
      name: { type: String }
    }
  }

  render() {
    return html`
      <h2>Hello ${this.name}</h2>
    `;
  }
}

window.customElements.define('my-test-element', MyTestElement);