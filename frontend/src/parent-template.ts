import { html, LitElement } from 'lit';
import 'child-template.ts';

class ParentTemplate extends LitElement {
  render() {
    return html`
      <div>Parent Template</div>
      <child-template id="childTemplate"></child-template>
    `;
  }
}

customElements.define('parent-template', ParentTemplate);