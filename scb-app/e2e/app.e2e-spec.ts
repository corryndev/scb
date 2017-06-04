import { ScbAppPage } from './app.po';

describe('scb-app App', () => {
  let page: ScbAppPage;

  beforeEach(() => {
    page = new ScbAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
