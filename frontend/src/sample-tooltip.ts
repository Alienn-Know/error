import { html, LitElement } from 'lit';

class SampleTooltip extends LitElement {
  render() {
    return html`
      <div part="content" theme="dark">
        <slot></slot>
      </div>
    `;
  }
}

customElements.define('sample-tooltip', SampleTooltip);