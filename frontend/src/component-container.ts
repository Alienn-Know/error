import { html, LitElement } from 'lit';

class ComponentContainer extends LitElement {
   render() {
     return html`
        <h1><slot name="title"></slot></h1>

        <div style="border: 1px solid black; margin: 5px;padding: 5px;">
            <slot>No content given!</slot>
        </div>
     `;
   }

}

customElements.define('component-container', ComponentContainer);