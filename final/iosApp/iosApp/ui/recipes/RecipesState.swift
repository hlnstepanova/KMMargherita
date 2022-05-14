//
//  RecipesState.swift
//  iosApp
//
//  Created by Lena Stepanova on 14.05.22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

class RecipesState: ObservableObject {
    
    let viewModel: RecipeViewModel
    
    @Published var recipes: [Recipe] = []
    
    init() {
        viewModel = RecipeViewModel()
        
        viewModel.observeRecipes{ recipes in
            self.recipes = recipes
        }
    }
    
    deinit {
        viewModel.dispose()
    }
    
}
