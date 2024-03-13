import { html, LitElement } from 'lit';

class ChildTemplate extends LitElement {
  render() {
    return html`<button>Child Template</button>`;
  }
}

customElements.define('child-template', ChildTemplate);